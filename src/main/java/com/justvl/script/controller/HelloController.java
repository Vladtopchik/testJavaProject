package com.justvl.script.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String viewIndex() {
        return "index";
    }

    @PostMapping("/")
    public String handleIndex() {

    }
}
