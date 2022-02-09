package ru.itis.javalab.impl;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import ru.itis.javalab.api.ApiApplication;

@SpringBootApplication
@Import(ApiApplication.class)
public class ImplApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImplApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
