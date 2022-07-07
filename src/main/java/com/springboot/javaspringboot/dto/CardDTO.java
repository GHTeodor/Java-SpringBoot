package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.Card;
import lombok.Data;

import java.util.List;

@Data
public class CardDTO {
    private boolean withPhoto;

//    public CardDTO(Card card) {
//        this.withPhoto = card.isWithPhoto();
//    }

    public CardDTO(List<Card> cards) {
        this.withPhoto = cards.get(0).isWithPhoto();
    }
}
