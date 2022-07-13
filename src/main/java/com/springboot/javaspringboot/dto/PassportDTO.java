package com.springboot.javaspringboot.dto;

import com.springboot.javaspringboot.models.Passport;
import lombok.Data;

@Data
public class PassportDTO {
    private String series;
    private String photo;

    public PassportDTO(Passport passport) {
        this.series = passport.getSeries();
        this.photo = passport.getPhoto();
    }
}
