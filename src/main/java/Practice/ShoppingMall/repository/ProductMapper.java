package Practice.ShoppingMall.repository;

import Practice.ShoppingMall.dto.OneDayClass;
import Practice.ShoppingMall.dto.PageProduct;
import Practice.ShoppingMall.dto.Product;
import Practice.ShoppingMall.dto.RecommendFlowerDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ProductMapper {

    //상품 아이디로 조회
    @Select("SELECT * FROM product WHERE product_id = #{productId}")
    Product findById(Integer productId);

    //가장 최근에 삽입한 상품 조회
    @Select("SELECT * FROM product ORDER BY product_id DESC limit 1")
    Product lastOne();
    //모든 상품 조회
    @Select("SELECT * FROM product")
    ArrayList<Product> findAll();


    @Select("SELECT COUNT(*) FROM product")
    Integer countProduct();

    //메인화면에 보여지는 상품 목록 호출
    @Select("select * from product ORDER BY product_id DESC limit 4")
    List<Product> pagenation();

    //상품 저장
    @Insert("INSERT INTO product(product_name, product_image,product_info, product_price) " +
            "VALUES(#{productName}, #{productImage},#{productInfo}, #{productPrice})")
    void insertProduct(Product product);

    //챗봇을 통해 추천받은 꽃 정보 저장
    @Insert("INSERT INTO recommend(recommend_Image, recommend_Name, recommend_Content) " +
            "VALUES(#{recommendImage}, #{recommendName}, #{recommendContent})")
    void insertRecommendFlower(RecommendFlowerDto recommendFlowerDto);

    //저장한 꽃 정보 불러오기
    @Select("SELECT * FROM recommend ORDER BY recommend_Id DESC limit 1")
    RecommendFlowerDto findPurchaseRecord();

    @Select("SELECT * FROM OneDayClass")
    List<OneDayClass> findOneDayClass();



}
