package com.mahedi.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/signing")
    public String signin(){
        return "login.html";
    }
}
