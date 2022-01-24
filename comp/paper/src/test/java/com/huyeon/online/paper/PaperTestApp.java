package com.huyeon.online.paper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
        "com.huyeon.online.config"
})
public class PaperTestApp {

    public static void main(String[] args) {
        SpringApplication.run(PaperTestApp.class, args);
    }

    @Configuration
    @EntityScan(basePackages = {
            "com.huyeon.online.user.domain",
            "com.huyeon.online.paper.domain"
    })
    @EnableJpaRepositories(basePackages = {
            "com.huyeon.online.user.repository",
            "com.huyeon.online.paper.repository"
    })
    class JpaConfig {

    }
}
