package com.huyeon.online;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class PaperUserTest {

    public static void main(String[] args) {
        SpringApplication.run(PaperUserTest.class, args);
    }

    @ComponentScan("com.huyeon.online.user")
    @EnableJpaRepositories(basePackages = {
            "com.huyeon.online.user.repository"
    })
    @EntityScan(basePackages = {
            "com.huyeon.online.user.domain"
    })
    @Configuration
    class config {

    }

}
