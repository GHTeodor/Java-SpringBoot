package com.springboot.javaspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@SpringBootApplication
public class JavaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringBootApplication.class, args);
    }
}
// User
//    id
//    name
//    Passport (1:1 unidirectional)
//    Card [] (1:n)
// Реалізувати базові crud операції (занйти, знайти по ід, видалити,оновити) для кожної стутності (User, Passport, Card)