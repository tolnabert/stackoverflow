package com.codecool.stackoverflowtw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StackoverflowTwApplication {

    private String URL = System.getenv("POSTGRES_URL");
    private String USER = System.getenv("POSTGRES_USER");
    private String PASSWORD = System.getenv("POSTGRES_PASSWORD");

    public static void main(String[] args) {

        SpringApplication.run(StackoverflowTwApplication.class, args);
    }
}
