package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


@Component
public class SomeComponent {

    private final DynamicBean1 dynamicBean;

    public SomeComponent(@Autowired(required = false) DynamicBean1 dynamicBean, @Autowired ApplicationContext applicationContext) {
        if(dynamicBean == null){
            System.out.println("=== Dynamic Bean is null ===");
            if(applicationContext.containsBeanDefinition("id1")){
                System.out.println("=== But the bean definition is known ===");
            }
        } else {
            System.out.println("=== Found dynamic bean! It is returning: " + dynamicBean.returnSomething() + " ===");
        }
        this.dynamicBean = dynamicBean;
    }

}
