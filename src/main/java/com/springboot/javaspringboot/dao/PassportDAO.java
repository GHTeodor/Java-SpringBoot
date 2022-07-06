package com.springboot.javaspringboot.dao;

import com.springboot.javaspringboot.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportDAO extends JpaRepository<Passport, Integer> {

}
