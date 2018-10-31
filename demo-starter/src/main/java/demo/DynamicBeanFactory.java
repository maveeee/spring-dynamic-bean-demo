package demo;

public class DynamicBeanFactory {

    public static final String FACTORY_BEAN_NAME = "beanFactory";
    public static final String FACTORY_METHOD_NAME = "createBean";

    private final DynamicBeanGenerator dynamicBeanFactoryDependency;

    public DynamicBeanFactory(DynamicBeanGenerator dynamicBeanFactoryDependency) {
        this.dynamicBeanFactoryDependency = dynamicBeanFactoryDependency;
    }

    public Object createBean(Class<?> clazz) {
        return dynamicBeanFactoryDependency.createDynamicBean(clazz);
    }
}
