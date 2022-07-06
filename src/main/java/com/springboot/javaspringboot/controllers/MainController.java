package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dao.UserDAO;
import com.springboot.javaspringboot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class MainController {
    @Autowired
    private UserDAO userDAO;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void saveUser(@RequestBody User user) {
        userDAO.save(user);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userDAO.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> byId = userDAO.findById(id);
        User user = byId.get();
        System.out.println("==============");
        System.out.println(user.getPassport());
        System.out.println("==============");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/name") // /users/name?name=Avocado
    public ResponseEntity<List<User>> getUserByName(@RequestParam String name) {
        List<User> usersByName = userDAO.getUserByName(name);
//        List<User> usersByName = userDAO.findByName(name);
        return new ResponseEntity<>(usersByName, HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<User> update/*ById*/(@RequestBody User user) {
        User save = userDAO.save(user);
        return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable int id) {
        userDAO.deleteById(id);
    }
}
