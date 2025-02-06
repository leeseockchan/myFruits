package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/admin/login")
    public String admin(){
        return "/user/login";
    }
    @GetMapping("/admin/dashboard")
    public String dashboard (){
        return "/common/dashboard";
    }

}
