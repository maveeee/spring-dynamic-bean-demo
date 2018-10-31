package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

@Configuration
public class CustomFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition dynamicBean1= new RootBeanDefinition("demo.DynamicBean1");
        BeanDefinition dynamicBean2= new RootBeanDefinition("demo.DynamicBean2");
        registry.registerBeanDefinition("dynamicBean1", dynamicBean1);
        registry.registerBeanDefinition("dynamicBean2", dynamicBean2);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        /**
         * See BeanFactoryPostProcessor{@link #postProcessBeanFactory(ConfigurableListableBeanFactory)} in order to check
         * whether you need to do some processing here or not
         */
    }
}
