package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.APIUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor

public class APIUserController {

    private final APIUserService apiUserService;

    @PostMapping("/api/v1/auth/signup")
    public String signup(@RequestBody UserDTO userDTO){

    apiUserService.signup(userDTO);
        return "저장성공";
    }
}
