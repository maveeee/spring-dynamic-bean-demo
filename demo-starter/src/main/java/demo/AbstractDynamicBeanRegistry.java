package demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Map;

import static demo.DynamicBeanFactory.FACTORY_BEAN_NAME;
import static demo.DynamicBeanFactory.FACTORY_METHOD_NAME;


public abstract class AbstractDynamicBeanRegistry implements BeanDefinitionRegistryPostProcessor {

    public abstract Map<String, Class<?>> getSomethingDeclaredByEndUser();

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        var dependencies = getSomethingDeclaredByEndUser();

        for(var dependency : dependencies.entrySet()) {
            var beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(dependency.getValue());
            beanDefinition.setScope(BeanDefinition.SCOPE_SINGLETON);
            beanDefinition.setAutowireCandidate(true);
            beanDefinition.setFactoryBeanName(FACTORY_BEAN_NAME);
            beanDefinition.setFactoryMethodName(FACTORY_METHOD_NAME);

            var ctorArgs = new ConstructorArgumentValues();
            ctorArgs.addGenericArgumentValue(dependency.getValue());
            beanDefinition.setConstructorArgumentValues(ctorArgs);

            registry.registerBeanDefinition(dependency.getKey(), beanDefinition);
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    }
}
