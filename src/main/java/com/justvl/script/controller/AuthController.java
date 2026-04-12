package com.justvl.script.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    @GetMapping("/register")
    public String viewRegster() {
        return "register";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }
}
