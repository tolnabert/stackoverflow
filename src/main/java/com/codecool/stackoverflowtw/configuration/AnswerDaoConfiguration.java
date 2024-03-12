package com.codecool.stackoverflowtw.configuration;

import com.codecool.stackoverflowtw.dao.answer.AnswersDAO;
import com.codecool.stackoverflowtw.dao.answer.AnswersDaoJdbc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerDaoConfiguration {

    @Bean
    public AnswersDAO answersDAO() {
        return new AnswersDaoJdbc();
    }

}
