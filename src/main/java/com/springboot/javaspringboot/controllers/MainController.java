package com.springboot.javaspringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("")
    public String name() {
        return "Security";
    }

    @PostMapping("/")
    public String homePost() {
        return "Home Post";
    }

    @PostMapping("/users")
    public String usersPost() {
        return "Users Post";
    }
}
