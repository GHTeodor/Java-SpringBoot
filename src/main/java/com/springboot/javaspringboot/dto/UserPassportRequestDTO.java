package com.springboot.javaspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPassportRequestDTO {
    private int user_id;
    private int passport_id;
}
