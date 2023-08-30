package Practice.ShoppingMall.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PageProduct {

    private int page = 1;
    private int pageSize = 3;

    public int getSkip(){
        return (page-1) * 3;
    }
}
