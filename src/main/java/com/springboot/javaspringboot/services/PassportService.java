package com.springboot.javaspringboot.services;

import com.springboot.javaspringboot.dao.PassportDAO;
import com.springboot.javaspringboot.models.Passport;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PassportService {
    private PassportDAO passportDAO;

    public Passport savePassport(Passport passport) {
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
