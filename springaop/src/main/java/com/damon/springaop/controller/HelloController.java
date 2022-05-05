package com.damon.springaop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * 定义一个Controller,在浏览器输出localhost:8080/hello时，需要传递一个
     * name的参数，所以访问形式就是：localhost:8080/hello?name=damon
     */
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "Hello " + name;
    }
    @GetMapping("/hello1")
    public String hello1(@RequestParam("name") String name, @RequestParam("age") String age){
        return "Hello " + name + " age = " + age;
    }
}
