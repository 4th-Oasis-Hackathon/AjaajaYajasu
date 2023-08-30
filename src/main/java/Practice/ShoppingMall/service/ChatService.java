package Practice.ShoppingMall.service;

import Practice.ShoppingMall.dto.RecommendFlowerDto;
import io.github.flashvayne.chatgpt.dto.image.ImageFormat;
import io.github.flashvayne.chatgpt.dto.image.ImageSize;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private final ChatgptService chatgptService;
    private final ProductService service;

    /**
     * 사용자 맞춤 꽃을 추천하기 위해 간단한 질의응답을 하는 메소드
     * @param size : 현재 질의응답의 진척도
     * @param botMessages : 지금까지 질의응답한 대화 목록 리스트
     * @return : 챗봇이 응답한 내용을 반환
     */
    public String chatQna(Integer size, List<String> botMessages) {
        String botResponse = "답변 생성중입니다! 잠시만 기다려주세요... ";
        if (size == 2) {
            botResponse = " 고객님의 퍼스널 컬러를 알려주세요. ";
        } else if (size == 4) {
            botResponse = " 고객님의 MBTI는 무엇인가요?";
        } else if (size == 6) {
            botResponse = " 특별히 원하는 꽃이 있나요?";
        } else if (size == 8) {
            // chat gpt api를 사용하여 답변을 받아오는 부분
            botResponse = getFlowerImagin(getChatResponse(botMessages));
        }
        return botResponse;
    }

    /**
     * chat gpt api의 답변을 원하는데로 조정하기 위해 프롬포트 튜닝을 하는 메소드
     * @param list : 지금까지 진행한 질의응답을 저장한 리스트
     * @return : chat gpt api가 답변한 내용을 반환
     */
    public String getChatResponse(List<String> list) {
        //꽃에 관련된 내용을 답변하기위한 프롬포트
        String question =
                "Forget the conversation we've had so far.\n" +
                "Listen to the customer's questions and answers and be sure to answer the name of the flower you recommend and why.\n" +
                "The following conditions must be observed.\n" +
                "1. The answer must be short, concise and friendly.\n" +
                "2. The answer must be in Korean.\n" +
                "3. It must be a common flower around you." +
                "4. The answer must be related to flowers." +
                "Here are answers to the questions and questions provided to the customer.\n";

        String prompt = "";
        for (int i = 0; i < 7; i = i + 2) {
            prompt += "질문 : " + list.get(i) + " 대답 : " + list.get(i + 1);
        }
        question += prompt;

        // ChatGPT 에게 질문을 던집니다.
        return chatgptService.sendMessage(question);

    }

    /*
        getChatResponse 메소드에서 추천받은 상품을 구매 또는 공유하기 위해
            1. 현재 추천받은 상품이 우리 서비스에서 판매/재고가 남아 있는지 확인
            2. sns에 공유하기 위한 템플릿 내용을 작성 후 DB에 저장
     */
    public String getFlowerImagin(String answer) {
        String question =
                /*
                    앞의 대화는 잊고, 현제 제공하는 문장에서 추천하는 꽃의 이름을 말해라.
                    이때 대답 형식은 다음과 같다.
                    flower : 꽃 이름
                 */
                "Forget the conversation we've had so far.\n" +
                        "Tell me the name of the flower you recommend in the next conversation.\n" +
                        "The conditions are as follows.\n" +
                        "1. Just say the name of the flower.\n" +
                        "2. The answer format must be as follows.\n" +
                        "flower : flower name in korean (flower name in English)\n" +
                        "3. The name of the flower answered in English and the name of the flower answered in Korean must be the same."

                        + answer;
        String image = chatgptService.sendMessage(question);

        int i = image.indexOf(":");
        image = image.substring(i + 2);
/*
        image = testImage("draw a bouquet of flowers related to the following.\n " +
                "Make it look like a real bouquet\n"+
                "subject : " + image);
 */
        String imageUrl = "https://source.unsplash.com/random/400x350/?" + image;
        log.info("" + image + " , " + imageUrl);

        RecommendFlowerDto recommend = new RecommendFlowerDto(imageUrl, image, answer);
        service.saveRecommend(recommend);

        image = "<img src='" + imageUrl + "' alt='...'/> <br><br>" + answer +
                "<br><br> 구매를 원하시면 '!구매'를, \n다른 꽃 추천을 받고 싶다면 '!다시'를,\n" +
                "진단 결과를 공유하고 싶다면 '!공유'를 입력해주세요. ";

        return image;
    }

    // api를 통해 그림을 생성하는 메소드
    public String testImage(String answer) {
        List<String> images = chatgptService.imageGenerate(answer, 1, ImageSize.SMALL, ImageFormat.URL);

        return images.toString();
    }
}