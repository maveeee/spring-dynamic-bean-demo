package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static demo.DynamicBeanFactory.FACTORY_BEAN_NAME;

@Configuration
public class DemoAutoConfiguration {

    @Bean
    public DynamicBeanGenerator dynamicBeanFactoryDependency(){
        return new DynamicBeanGenerator();
    }

    @Bean(FACTORY_BEAN_NAME)
    public DynamicBeanFactory dynamicBeanFactory(DynamicBeanGenerator dynamicBeanFactoryDependency){
        return new DynamicBeanFactory(dynamicBeanFactoryDependency);
    }
}
