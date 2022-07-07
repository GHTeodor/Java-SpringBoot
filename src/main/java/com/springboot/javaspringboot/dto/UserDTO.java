package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.User;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class UserDTO {
    private String name;
    private PassportDTO passportDTO;
    private List<CardDTO> cardsDTO;

    public UserDTO(User user) {
        this.name = user.getName();
        this.passportDTO = new PassportDTO(user.getPassport());
        this.cardsDTO = Arrays.asList(new CardDTO(user.getCards()));
    }
}
