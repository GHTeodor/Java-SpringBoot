package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dao.PassportDAO;
import com.springboot.javaspringboot.models.Passport;
import com.springboot.javaspringboot.services.PassportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passports")
public class PassportController {
    @Autowired
    private PassportService passportService;

    @PostMapping("")
    public ResponseEntity<Passport> savePassport(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportService.savePassport(passport), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Passport>> getAll() {
        return new ResponseEntity<>(passportService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passport> getOneById(@PathVariable int id) {
        return new ResponseEntity<>(passportService.getOneById(id), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<Passport> update(@RequestBody Passport passport) {
        return new ResponseEntity<>(passportService.update(passport), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable int id) {
        passportService.getOneById(id);
    }
}
