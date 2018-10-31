package demo;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class ApplicationConfiguration {

    @Bean
    public static BeanDefinitionRegistryPostProcessor ContractConfiguration() {
        return new AbstractDynamicBeanRegistry() {

            @Override
            public Map<String, Class<?>> getSomethingDeclaredByEndUser() {
                return new HashMap<>() {{
                    put("id1", DynamicBean1.class);
                    put("id2", DynamicBean2.class);
                }};
            }
        };
    }
}
