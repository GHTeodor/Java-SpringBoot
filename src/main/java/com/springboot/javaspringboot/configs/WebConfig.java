package com.springboot.javaspringboot.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        img/**.jpg
        String path = "file:///" + System.getProperty("user.home") + File.separator + "" + File.separator;
        registry.addResourceHandler("img/**")
                .addResourceLocations(path);
    }
}
