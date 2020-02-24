package com.demo.demo_web.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.demo.bean.DemoResult;

/**
 * @program: springboot_demo
 * @description:
 * @author: zhaoshouyun
 * @create: 2020-02-24 15:06
 **/
public class ExceptionUtil {

    public static DemoResult<String> handleException(String name,BlockException ex) {
        System.out.println("测试。。。。。。。。。。。。。。。。。。。。。。");
        return DemoResult.FAIL("请求频率太高，请稍后重试");
    }
    public static DemoResult<String> exceptionHandler(String name,BlockException ex) {
        System.out.println("1231231232131。。。。。。。。。。。。。");
        return DemoResult.FAIL("请求频率太高，请稍后重试......");
    }
}
