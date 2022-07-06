package com.springboot.javaspringboot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean biometric;
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    private User user;
}
