package com.springboot.javaspringboot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean biometric;
    @OneToOne(mappedBy = "passport", cascade = CascadeType.ALL)
    @JsonIgnore()
    private User user;
}
