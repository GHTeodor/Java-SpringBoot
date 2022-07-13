package com.springboot.javaspringboot.services;

import com.springboot.javaspringboot.dao.PassportDAO;
import com.springboot.javaspringboot.dao.UserDAO;
import com.springboot.javaspringboot.dto.UserDTO;
import com.springboot.javaspringboot.dto.UserPassportRequestDTO;
import com.springboot.javaspringboot.models.Passport;
import com.springboot.javaspringboot.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private UserDAO userDAO;
    private PassportDAO passportDAO;
    private MailService mailService;

    public List<UserDTO> saveOne(User user) {
        if (user.getName() != null){
            userDAO.save(user);
            mailService.sendEmail(user);
        }
        return userDAO.findAll().stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public List<UserDTO> getAll() {
        List<User> all = userDAO.findAll();
        return all.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public User getOneById (int id){
        Optional<User> byId = userDAO.findById(id);
        return byId.orElse(new User());
    }

    public List<User> getUserByName(String name) {
        return userDAO.getUserByName(name);
//        return userDAO.findByName(name);
    }

    public User updateOne(UserPassportRequestDTO dto) {
        int user_id = dto.getUser_id();
        int passport_id = dto.getPassport_id();
        User user = userDAO.findById(user_id).orElse(new User());
        Passport passport = passportDAO.findById(passport_id).orElse(new Passport());
        user.setPassport(passport);

        return userDAO.save(user);
    }

    public void deleteOneById(int id) {
        userDAO.deleteById(id);
    }

    public String activateAccount(int id) {
        User user = getOneById(id);
        user.setActivated(true);
        userDAO.save(user);
        return "Account activated";
    }
}
