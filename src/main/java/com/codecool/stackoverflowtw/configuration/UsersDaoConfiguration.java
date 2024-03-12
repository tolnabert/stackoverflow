package com.codecool.stackoverflowtw.configuration;

import com.codecool.stackoverflowtw.dao.user.UsersDao;
import com.codecool.stackoverflowtw.dao.user.UsersDaoJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsersDaoConfiguration {

    private final static String URL = System.getenv("POSTGRES_URL");
    private final static String USER = System.getenv("POSTGRES_USER");
    private final static String PASSWORD = System.getenv("POSTGRES_PASSWORD");
//    TODO: Add the url of your database to the Environment Variables of the Run Configuration
//    @Value("${askmate.database.url}")
//    private String databaseUrl;

    @Bean
    public UsersDao usersDao() {
        return new UsersDaoJdbc();
    }
}

