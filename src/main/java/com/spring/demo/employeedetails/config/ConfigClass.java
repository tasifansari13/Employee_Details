package com.spring.demo.employeedetails.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

//@Profile("!dev") // Use for all env except dev
@Profile("dev") // Use only for dev env
@Configuration
public class ConfigClass {

    @PostConstruct
    public void test() {
        System.out.println("Loaded from dev env");
    }
}
