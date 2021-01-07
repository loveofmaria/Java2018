package AnnotationsDemo;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotationTest {
    String value() default "Hello";
}
