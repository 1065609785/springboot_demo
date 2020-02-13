package com.demo.demo_web.encry;

import com.alibaba.fastjson.JSON;
import com.demo.utils.AESUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: springboot_demo
 * @description: 对body体进行加密
 * @author: zhaoshouyun
 * @create: 2020-01-20 15:32
 **/
@Component
@Slf4j
@ControllerAdvice(basePackages="com.demo.demo_web.encryController")
public class EncryResponseBodyAdvice implements ResponseBodyAdvice {
    /**
     * Whether this component supports the given controller method return type
     * and the selected {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        log.info("supports====================启用加密拦截器");
        return true;
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        //通过 ServerHttpRequest的实现类ServletServerHttpRequest 获得HttpServletRequest
        ServletServerHttpRequest sshr = (ServletServerHttpRequest) request;
        //此处获取到request 是为了取到在拦截器里面设置的一个对象 是我项目需要,可以忽略
        HttpServletRequest httpServletRequest = sshr.getServletRequest();

        String returnStr = "";
        try {
            //添加encry header，告诉前端数据已加密
            response.getHeaders().add("encry", "true");
            String srcData = JSON.toJSONString(body);
            //加密
            returnStr = AESUtil.encrypt(srcData);
            log.info("接口={},原始数据={},加密后数据={}", httpServletRequest.getRequestURI(), srcData, returnStr);

        } catch (Exception e) {
            log.error("异常！", e);
        }
        return returnStr;
    }
}
