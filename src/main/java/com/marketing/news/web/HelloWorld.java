package com.marketing.news.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String sayHello(@RequestParam(value="name") String name){
        return "Hello " + name + " !";
    }
}
