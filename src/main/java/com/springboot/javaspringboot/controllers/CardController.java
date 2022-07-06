package com.springboot.javaspringboot.controllers;

import com.springboot.javaspringboot.dao.CardDAO;
import com.springboot.javaspringboot.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {
    @Autowired
    private CardDAO cardDAO;

    @PostMapping("")
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        return new ResponseEntity<>(cardDAO.save(card), HttpStatus.CREATED);
    }


    @GetMapping("")
    public ResponseEntity<List<Card>> getAll() {
        return new ResponseEntity<>(cardDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getOneById(@PathVariable int id) {
        return new ResponseEntity<>(cardDAO.findById(id).get(), HttpStatus.OK);
    }

    @PatchMapping("")
    public ResponseEntity<Card> update(@RequestBody Card card) {
        return new ResponseEntity<>(cardDAO.save(card), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOneById(@PathVariable int id) {
        cardDAO.deleteById(id);
    }
}
