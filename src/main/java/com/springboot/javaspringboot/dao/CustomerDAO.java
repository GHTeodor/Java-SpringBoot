package com.springboot.javaspringboot.dao;

import com.springboot.javaspringboot.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findByLogin(String login);
}