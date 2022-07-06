package com.springboot.javaspringboot.dao;

import com.springboot.javaspringboot.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDAO extends JpaRepository<Card, Integer> {
}
