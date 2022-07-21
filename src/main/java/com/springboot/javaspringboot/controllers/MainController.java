package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dao.CustomerDAO;
import com.springboot.javaspringboot.models.Customer;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MainController {
    private CustomerDAO customerDAO;
    private PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String name() {
        return "Security";
    }

    @PostMapping("/")
    public String homePost() {
        return "Home Post";
    }

    @GetMapping("/customers")
    public String users() {
        return "Users";
    }
    @PostMapping("/customers")
    public void saveUser(@RequestBody Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerDAO.save(customer);
    }
}
