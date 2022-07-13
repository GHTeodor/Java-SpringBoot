package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPassportResponseDTO {
    private String username;
    private String passportStatus;

    public UserPassportResponseDTO(User user) {
        this.username = user.getName();
        this.passportStatus = user.getPassport().getSeries();
    }
}
