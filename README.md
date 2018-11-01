# spring-dynamic-bean-demo
This repository displays a problem I am having with injecting dynamically created beans.

Two dynamic beans are registered through a BeanDefinitionRegistryPostProcessor defined through the @Configuration ApplicationConfiguration.
I try to autowire one of the Beans into a class annotated with @Component, however, Spring tries to create the component before its dependency (the dynamic bean) is created.
