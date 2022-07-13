package com.springboot.javaspringboot.services;

import com.springboot.javaspringboot.dao.PassportDAO;
import com.springboot.javaspringboot.models.Passport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PassportService {
    private PassportDAO passportDAO;

    public Passport savePassport(Passport passport) {
        return passportDAO.save(passport);
    }

    public Passport savePassportWithPhoto(String series, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        File dest = new File(System.getProperty("user.home") + File.separator + "" + File.separator + originalFilename);
        file.transferTo(dest);
        Passport passport = new Passport(series, originalFilename);
        return passportDAO.save(passport);
    }

    public List<Passport> getAll() {
        return passportDAO.findAll();
    }

    public Passport getOneById(int id) {
        return passportDAO.findById(id).orElse(new Passport());
    }

    public Passport update(Passport passport) {
        return passportDAO.save(passport);
    }

    public void deleteOneById(int id) {
        passportDAO.deleteById(id);
    }
}
