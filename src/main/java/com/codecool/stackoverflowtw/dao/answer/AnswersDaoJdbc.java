package com.codecool.stackoverflowtw.dao.answer;

import com.codecool.stackoverflowtw.dao.answer.model.Answer;

import java.util.List;

public class AnswersDaoJdbc implements AnswersDAO {
    @Override
    public List<Answer> getAllAnswersForQuestion(int question_id) {
        // TODO SQL query answers for question from database
        throw new UnsupportedOperationException();
    }
}
