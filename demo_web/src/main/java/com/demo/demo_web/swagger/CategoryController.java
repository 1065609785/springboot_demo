package com.demo.demo_web.swagger;

import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: springboot_demo
 * @description: 分类
 * @author: zhaoshouyun
 * @create: 2020-01-13 17:02
 **/
@RestController
public class CategoryController {
    @RequestMapping(value = "/category/Resource", method = RequestMethod.GET)
    public ResponseEntity<String> search(@RequestParam Category someEnum) {
        return ResponseEntity.ok(someEnum.name());
    }

    @RequestMapping(value = "/category/map", method = RequestMethod.GET)
    public Map<String, Map<String, String>> map() {
        return new HashMap();
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> someOperation(@PathVariable long id, @RequestBody int userId) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/category/{id}/{userId}", method = RequestMethod.POST)
    public ResponseEntity<Void> ignoredParam(@PathVariable long id, @PathVariable @ApiIgnore int userId) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/category/{id}/map", method = RequestMethod.POST)
    public ResponseEntity<Void> map(@PathVariable String id, @RequestParam Map<String, String> test) {
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public ResponseEntity<List<Category>> map(String [] categories) {
        return ResponseEntity.ok(null);
    }


}
