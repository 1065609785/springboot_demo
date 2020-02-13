package com.demo.demo_web.encryController;

import com.alibaba.fastjson.JSON;
import com.demo.bean.DemoResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: springboot_demo
 * @description: 需要进行加解密controller
 * @author: zhaoshouyun
 * @create: 2020-01-20 15:38
 **/
@RestController
@RequestMapping("encry")
@Slf4j
public class MyController {

   /**
    * @Description 测试加密
    * @Author zhaoshouyun
    * @Date 2020-01-20 03:43
    * @Param name
    * @Param map
    * @return com.demo.bean.DemoResult<java.lang.String>
    **/
    @RequestMapping("test")
    public DemoResult<Map> test(@RequestBody Map<String,Object> object){
        log.info("相关参数:{}", JSON.toJSONString(object));
        return DemoResult.SUCCESS(object);
    }
}
