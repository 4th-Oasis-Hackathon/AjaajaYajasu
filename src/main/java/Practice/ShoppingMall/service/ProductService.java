package Practice.ShoppingMall.service;

import Practice.ShoppingMall.dto.Product;
import Practice.ShoppingMall.dto.RecommendFlowerDto;
import Practice.ShoppingMall.repository.ProductMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter @Setter
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public Product saveProduct(Product product){
        productMapper.insertProduct(product);
        return productMapper.lastOne();
    }

    public void saveRecommend(RecommendFlowerDto recommendFlowerDto){
        productMapper.insertRecommendFlower(recommendFlowerDto);
    }

    public RecommendFlowerDto findPurchaseRecord(){
        return productMapper.findPurchaseRecord();
    }



}
