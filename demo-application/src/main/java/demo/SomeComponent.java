package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class SomeComponent {

    private final DynamicBean1 dynamicBean;

    public SomeComponent(@Autowired(required = false) DynamicBean1 dynamicBean) {
        if(dynamicBean == null){
            System.out.println("Dynamic Bean is null");
        } else {
            System.out.println("=== Found dynamic bean! It is returning: " + dynamicBean.returnSomething() + " ===");
        }
        this.dynamicBean = dynamicBean;
    }
}
