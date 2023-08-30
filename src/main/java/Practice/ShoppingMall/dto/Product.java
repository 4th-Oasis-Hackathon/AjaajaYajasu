package Practice.ShoppingMall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Product {
    private Integer productId;
    private String productName;
    private String productImage;
    private String productInfo;
    private Integer productPrice;

    public Product() {
    }

    public Product(
            Integer productId, String productName, String productImage,
            String productInfo, Integer productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
    }
}
