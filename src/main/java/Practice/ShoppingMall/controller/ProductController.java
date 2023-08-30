package Practice.ShoppingMall.controller;

import Practice.ShoppingMall.dto.GatherClass;
import Practice.ShoppingMall.dto.Product;
import Practice.ShoppingMall.dto.RecommendFlowerDto;
import Practice.ShoppingMall.repository.ProductMapper;
import Practice.ShoppingMall.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    //DB 관련 로직
    private final ProductMapper productMapper;
    //챗봇 핵심 로직
    private final ChatService chatService;

    //SNS 공유를 위한 api키.
    @Value("${kakao.api-key}")
    private String kakaoApikey;
    //챗봇을 통한 질의응답을 저장하는 리스트
    private List<String> botMessages = new ArrayList<>();

    /**
     * 메인 페이지로 이동하는 컨트롤러
     * - 메인 페이지에 추천 컨텐츠와 인기있는 원데이 클래스 수업 목록을 전달한다.
     */
    @GetMapping("/main")
    public String mainPage(Model model) {
        log.info("= 메인 페이지 =");
        GatherClass gatherClass = new GatherClass();
        gatherClass.setOneDayClass(productMapper.findOneDayClass());
        gatherClass.setProduct(productMapper.pagenation());

        model.addAttribute("gatherClass", gatherClass);

        return "/main";
    }

    /**
     * 꽃다발 추천 챗봇 페이지로 이동하는 컨트롤러
     * - sns 공유를 위한 api key를 매개변수로 넘긴다.
     * - 질의응답을 저장하기 위한 'bot message' 리스트를 초기화한다.
     */
    @GetMapping("/chat")
    public String chat(Model model) {
        // log.info(""+botMessages.size());

        botMessages.clear();
        if (botMessages.size() == 0) {
            botMessages.add("성별과 연령대를 알려주세요.");
        }
        model.addAttribute("kakaoApikey", kakaoApikey);

        return "/chatBot/chat";
    }

    /**
     * 사용자 응답을 받아오고, 그에 대한 답변을 반환하는 컨트롤러
     * - chatService 클래스는 챗봇 핵심 비지니스 로직이 있는 클래스
     */
    @PostMapping("/chat")
    @ResponseBody
    public String sendMessage(@RequestBody String userMessage) {

        botMessages.add(userMessage);

        String botResponse = chatService.chatQna(botMessages.size(), botMessages);

        botMessages.add(botResponse);
        log.info("user message : " + userMessage + " size : " + botMessages.size());

        return botResponse;
    }

    /**
     * 상품 목록을 반환하는 컨트롤러
     */
    @GetMapping("/list")
    public String listPage(Model model) {
        log.info("= 더보기 페이지 =");
        //model.addAttribute("products", productMapper.findAll());
        model.addAttribute("products", productMapper.findAll());
        return "/list";
    }


    /**
     * 상품 상세 페이지를 반환하는 컨트롤러
     */
    @GetMapping("/product/{productId}")
    public String productPage(@PathVariable(name = "productId") Integer productId, Model model) {
        log.info("= 상품 상세 페이지 =" + productId);
        Product product = productMapper.findById(productId);
        model.addAttribute("product", product);

        return "/productInfo";
    }


    @GetMapping("/product")
    public String productPage() {

        ArrayList<Product> list = productMapper.findAll();

        for (Product product : list) {
            log.info(product.getProductName());
        }
        return "/main";
    }


    /**
     * 상품 추가 페이지를 반환하는 컨트롤러
     */
    @GetMapping("/add")
    public String addProductPage() {
        log.info("= 상품추가 페이지 =");

        return "/addProduct";
    }

    /**
     * 상품을 추가하는 컨트롤러
     */
    @PostMapping("/add")
    public String addProductPage(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        log.info("= 상품추가 성공 =");
        productMapper.insertProduct(product);
        redirectAttributes.addAttribute("productId", productMapper.lastOne().getProductId());
        return "redirect:/product/{productId}";
    }

    /**
     * 챗봇에서 추천받는 상품의 상세 페이지를 보여주는 컨트롤러
     */
    @GetMapping("/purchase")
    public String purchaseFlower(Model model){
        log.info("= 챗봇 추천 상품 페이지 이동 =");

        RecommendFlowerDto purchase = productMapper.findPurchaseRecord();
        model.addAttribute("purchase", purchase);
        return "/chatBot/purchase";
    }

    /**
     * 챗봇에서 추천 받은 상품을 SNS에 공유하는 페이지를 호출
     */
    @GetMapping("/shareSns")
    public String shareSns(Model model){
        log.info("= 상품구매 페이지 이동 =");

        RecommendFlowerDto purchase = productMapper.findPurchaseRecord();
        purchase.setApiKey(kakaoApikey);
        model.addAttribute("purchase", purchase);
        return "/chatBot/shareSns";
    }

    /**
     * 테스트 용
     */
    @GetMapping("/test")
    public String test() {
        log.info("= 테스트 =");
        return "/test";
    }


}
