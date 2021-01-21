package com.example.demo.tutorial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/")
    public String get() {
        return "Home";
    }

    @RequestMapping("/greeting")
    public String getGreeting() {
        return "Hello World!";
    }

}
