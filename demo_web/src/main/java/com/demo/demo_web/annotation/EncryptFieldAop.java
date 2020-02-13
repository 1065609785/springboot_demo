package com.demo.demo_web.annotation;

import com.demo.utils.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @program: springboot_demo
 * @description: 加解密切面
 * @author: zhaoshouyun
 * @create: 2020-01-21 15:04
 **/
@Order(Ordered.HIGHEST_PRECEDENCE)
@Aspect
@Component
@Slf4j
public class EncryptFieldAop {

    @Pointcut("@annotation(com.demo.demo_web.annotation.EncryptMethod)")
    public void annotationPointCut() {
    }

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object responseObj = null;
        try {
           // log.info(JSON.toJSONString(joinPoint.getArgs()));
            Object requestObj = joinPoint.getArgs()[0];
            handleEncrypt(requestObj);
            responseObj = joinPoint.proceed();
            handleDecrypt(responseObj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", e);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error("SecureFieldAop处理出现异常{}", throwable);
        }
        return responseObj;
    }

    /**
     * 处理加密
     *
     * @param requestObj
     */
    private void handleEncrypt(Object requestObj) throws IllegalAccessException {
        if (Objects.isNull(requestObj)) {
            return;
        }
        Field[] fields = requestObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String plaintextValue = (String) field.get(requestObj);
                String encryptValue = AESUtil.encrypt(plaintextValue);
                field.set(requestObj, encryptValue);
            }
        }
    }


    /**
     * 处理解密
     *
     * @param responseObj
     */
    private Object handleDecrypt(Object responseObj) throws IllegalAccessException {
        if (Objects.isNull(responseObj)) {
            return null;
        }

        Field[] fields = responseObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String encryptValue = (String) field.get(responseObj);
                String plaintextValue = AESUtil.decrypt(encryptValue);
                field.set(responseObj, plaintextValue);
            }
        }
        return responseObj;
    }
}
