package com.fruit.pms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "common/hello";
    }

    @GetMapping("/")
    public String home() {
        return "common/home";
    }

}
