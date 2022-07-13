package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.Passport;
import lombok.Data;

@Data
public class PassportDTO {
    private String series;

    public PassportDTO(Passport passport) {
        this.series = passport.getSeries();
    }
}
