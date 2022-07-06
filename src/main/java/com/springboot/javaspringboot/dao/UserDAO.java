package com.springboot.javaspringboot.dao;

import com.springboot.javaspringboot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.name=:name")
    List<User> getUserByName(@Param("name") String username);

    List<User> findByName(String name);
}
