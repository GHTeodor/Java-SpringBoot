package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MainController {
    ArrayList<User> users = new ArrayList<>();

    public MainController() {
        users.add(new User(1, "Blackberries"));
        users.add(new User(2, "Blueberries"));
        users.add(new User(3, "Cranberries"));
        users.add(new User(4, "Elderberries"));
        users.add(new User(5, "Gooseberries"));
        users.add(new User(6, "Raspberries"));
        users.add(new User(7, "Strawberries"));
//        System.out.println(this.getClass().getSimpleName());
    }

    @GetMapping("/hello")
    public void hello() {
        System.out.println("Hello");
    }

    @GetMapping("/")
    public ResponseEntity<String> body() {
        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("This is body response", HttpStatus.OK);
        return stringResponseEntity;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return users;
    }

//    @PostMapping("/users")
//    public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
//        users.add(user);
//        return new ResponseEntity<>(users, HttpStatus.CREATED);
//    }

    @PostMapping("/users") // http://localhost:8080/users?id=8&name=Avocado
    public ResponseEntity<List<User>> saveUser(@RequestParam int id, @RequestParam String name) {
        users.add(new User(id, name));
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User u = users.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
//        Iterator<User> iterator = users.iterator();
//        while (iterator.hasNext()) {
//            User user = iterator.next();
//            if (user.getId() == id) iterator.remove();
//        }
        users.removeIf(user -> user.getId() == id);
    }
}
