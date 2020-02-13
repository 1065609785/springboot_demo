package com.demo.demo_web.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: springboot_demo
 * @description: home
 * @author: zhaoshouyun
 * @create: 2020-01-13 16:59
 **/
@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
