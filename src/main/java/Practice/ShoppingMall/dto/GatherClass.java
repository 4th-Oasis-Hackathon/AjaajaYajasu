package Practice.ShoppingMall.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class GatherClass {

    private List<OneDayClass> oneDayClass;
    private List<Product> product;

    public GatherClass() {
    }

    public GatherClass(List<OneDayClass> oneDayClass, List<Product> product) {
        this.oneDayClass = oneDayClass;
        this.product = product;
    }


}
