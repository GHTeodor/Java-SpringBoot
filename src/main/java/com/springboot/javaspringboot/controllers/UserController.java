package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dto.UserDTO;
import com.springboot.javaspringboot.dto.UserPassportRequestDTO;
import com.springboot.javaspringboot.dto.UserPassportResponseDTO;
import com.springboot.javaspringboot.models.User;
import com.springboot.javaspringboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> saveUser(@RequestBody @Valid User user) {
        return userService.saveOne(user);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOneById(@PathVariable int id) {
        return new ResponseEntity<>(userService.getOneById(id), HttpStatus.OK);
    }

    @GetMapping("/name") // /users/name?name=Avocado
    public ResponseEntity<List<User>> getUserByName(@RequestParam String name) {
        return new ResponseEntity<>(userService.getUserByName(name), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<UserPassportResponseDTO> updateOne(@RequestBody UserPassportRequestDTO dto) {
        User user = userService.updateOne(dto);
        return new ResponseEntity<>(new UserPassportResponseDTO(user), HttpStatus.ACCEPTED);
    }
//    @PatchMapping("")
//    public ResponseEntity<User> update(@RequestBody User user) {
//        User save = userDAO.save(user);
//        return new ResponseEntity<>(save, HttpStatus.ACCEPTED);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable int id) {
        userService.deleteOneById(id);
    }

    @GetMapping("/activateAccount/{id}")
    public ResponseEntity<String> activateAccount(@PathVariable int id) {
        return new ResponseEntity<>(userService.activateAccount(id), HttpStatus.OK);
    }
}
