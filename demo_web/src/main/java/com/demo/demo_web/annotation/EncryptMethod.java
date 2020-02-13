package com.demo.demo_web.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @program: springboot_demo
 * @description: 针对方法进行加解密注解,
 * @author: zhaoshouyun
 * @create: 2020-01-21 15:00
 **/
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EncryptMethod {
}
