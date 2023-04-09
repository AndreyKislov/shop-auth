package ua.kislov.reg_and_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RegAndAuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegAndAuthServiceApplication.class, args);
    }

}
