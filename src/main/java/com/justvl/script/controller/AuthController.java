package com.justvl.script.controller;

import com.justvl.script.dto.RegisterForm;
import com.justvl.script.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/register")
    public String viewRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String viewRegister(@ModelAttribute RegisterForm registerForm) {
//        System.out.println(registerForm.getUsername());
//        System.out.println(registerForm.getPassword());
//        System.out.println(registerForm.getRemember());
        userService.createUser(registerForm.getUsername(), registerForm.getPassword());
        return "redirect:/";
    }
}
