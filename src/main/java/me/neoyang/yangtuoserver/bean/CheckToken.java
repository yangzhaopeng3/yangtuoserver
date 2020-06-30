package me.neoyang.yangtuoserver.bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @name: CheckToken
 * @desc:
 * @author: Zhaopeng Yang
 * @create: 2020-06-30 18:27
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckToken {
    boolean required() default true;
}