package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dao.PassportDAO;
import com.springboot.javaspringboot.models.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passports")
public class PassportController {
    @Autowired
    private PassportDAO passportDAO;

    @PostMapping("")
    public ResponseEntity<Passport> savePassport(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportDAO.save(passport), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Passport>> getAll() {
        return new ResponseEntity<>(passportDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getOneById(@PathVariable int id) {
        return new ResponseEntity<>(passportDAO.findById(id).get(), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<Passport> update(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportDAO.save(passport), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable int id) {
        passportDAO.deleteById(id);
    }
}
