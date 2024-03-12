package com.codecool.stackoverflowtw.dao.answer;

import com.codecool.stackoverflowtw.dao.answer.model.Answer;

import java.util.List;

public interface AnswersDAO {

    List<Answer> getAllAnswersForQuestion(int question_id);

}
