package com.codecool.stackoverflowtw.configuration;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuestionDaoConfiguration {

    private final static String URL = System.getenv("POSTGRES_URL");
    private final static String USER = System.getenv("POSTGRES_USER");
    private final static String PASSWORD = System.getenv("POSTGRES_PASSWORD");
//    TODO: Add the url of your database to the Environment Variables of the Run Configuration
//    @Value("${askmate.database.url}")
//    private String databaseUrl;

    @Bean
    public QuestionsDAO questionsDAO() {
        return new QuestionsDaoJdbc();
    }
}
