package com.bookstore.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("welcome")
    public String hello(){
        return "Welcome to Spring boot";
    }
}
