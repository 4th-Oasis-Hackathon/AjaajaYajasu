package Practice.ShoppingMall.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OneDayClass {

    private Integer classId;
    private String className;
    private String classImage;
    private String  classInfo;
    private String classPrice;

    public OneDayClass() {
    }

    public OneDayClass(Integer classId, String className, String classImage, String classInfo, String classPrice) {
        this.classId = classId;
        this.className = className;
        this.classImage = classImage;
        this.classInfo = classInfo;
        this.classPrice = classPrice;
    }
}
