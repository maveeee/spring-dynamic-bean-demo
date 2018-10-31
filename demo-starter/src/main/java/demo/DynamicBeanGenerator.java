package demo;

import java.lang.reflect.InvocationTargetException;

public class DynamicBeanGenerator {

    public DynamicBeanGenerator() {
    }

    public Object createDynamicBean(Class<?> clazz){
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
