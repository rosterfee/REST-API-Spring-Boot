package ru.itis.javalab.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.itis.javalab.api.ApiApplication;
import ru.itis.javalab.impl.ImplApplication;

@SpringBootApplication
@Import({ApiApplication.class, ImplApplication.class})
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
