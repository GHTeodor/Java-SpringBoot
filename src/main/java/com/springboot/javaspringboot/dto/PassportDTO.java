package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.Passport;
import lombok.Data;

@Data
public class PassportDTO {
    private boolean biometric;

    public PassportDTO(Passport passport) {
        this.biometric = passport.isBiometric();
    }
}
