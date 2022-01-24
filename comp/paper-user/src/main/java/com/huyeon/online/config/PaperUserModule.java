package com.huyeon.online.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.huyeon.online.user")
@EnableJpaRepositories(basePackages = {
        "com.huyeon.online.user.repository"
})
@EntityScan(basePackages = {
        "com.huyeon.online.user.domain"
})
public class PaperUserModule {
}
