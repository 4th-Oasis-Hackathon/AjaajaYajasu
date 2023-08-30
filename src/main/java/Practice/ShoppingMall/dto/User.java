package Practice.ShoppingMall.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Getter @Setter
@Slf4j
public class User {
    private Integer userId;
    private String name;
    private ArrayList<Product> userInfo;

    public User() {
    }

    public User(Integer userId, String name, ArrayList<Product> userInfo) {
        this.userId = userId;
        this.name = name;
        this.userInfo = userInfo;
    }
}
