package com.study.prictice.demos.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author ouyang    @Date 2023/4/13
 * @Description  自定义注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})   //@Target 注解声名你自己定义的注解作用的地方
@Retention(RetentionPolicy.RUNTIME)         //@Retention  注解声名你注解的声名周期
public @interface annotationTest {
    public int getAge();
    int age() default 18;
}
