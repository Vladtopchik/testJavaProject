package com.justvl.script.controller;

import com.justvl.script.dto.RegisterForm;
import com.justvl.script.entity.AppUser;
import com.justvl.script.service.JwtService;
import com.justvl.script.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/register")
    public String viewRegister() {
        return "register";
    }

    @GetMapping("/login")
    public String viewLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String viewRegister(@ModelAttribute RegisterForm registerForm, HttpServletResponse response) {

//        System.out.println(registerForm.getUsername());
//        System.out.println(registerForm.getPassword());
//        System.out.println(registerForm.getRemember());
        AppUser appUser = userService.createUser(registerForm.getUsername(), registerForm.getPassword());

        Cookie cookie = new Cookie("token", jwtService.generateToken(
                appUser.getId(), appUser.getUsername()
        ));

        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge((int) jwtService.getLifetime());

        response.addCookie(cookie);
        
        return "redirect:/";
    }
}
