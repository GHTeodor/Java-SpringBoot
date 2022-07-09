package com.springboot.javaspringboot.services;

import com.springboot.javaspringboot.dao.CardDAO;
import com.springboot.javaspringboot.models.Card;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CardService {
    private CardDAO cardDAO;

    public Card saveCard(Card card) {
        return cardDAO.save(card);
    }

    public List<Card> getAll() {
        return cardDAO.findAll();
    }

    public Card getOneById(int id) {
        return cardDAO.findById(id).orElse(new Card());
    }

    public Card update(Card card) {
        return cardDAO.save(card);
    }

    public void deleteOneById(int id) {
        cardDAO.deleteById(id);
    }
}
