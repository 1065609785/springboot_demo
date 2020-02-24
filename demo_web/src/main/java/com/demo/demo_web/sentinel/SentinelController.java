package com.demo.demo_web.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.demo.bean.DemoResult;
import com.demo.service.CgsService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot_demo
 * @description: 流量防卫兵Contrller
 * @author: zhaoshouyun
 * @create: 2020-02-24 13:22
 **/
@RestController
public class SentinelController {

    @Reference(version = "1.0.0")
    CgsService cgsService;

    @SentinelResource(value = "hello", blockHandler = "handleException",blockHandlerClass = ExceptionUtil.class,fallback = "exceptionHandler",fallbackClass = ExceptionUtil.class)
    @RequestMapping("hello")
    public DemoResult<String> hello(String name){

        if (StringUtils.isBlank(name)){
            throw new RuntimeException("姓名不能为空");
        }
        //List<CgsDksq> cgsDksqList = cgsService.listCgsDksq(new CgsDksq());

        return DemoResult.SUCCESS("成功："+name);
    }



}
