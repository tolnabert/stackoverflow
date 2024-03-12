package com.codecool.stackoverflowtw.dao.questioon;

import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.questioon.model.Question;

import java.util.List;

public interface QuestionsDAO {
    List<Question> getAllQuestions();

    Question getQuestionById(int id);

    int addNewQuestion(NewQuestionDTO question);

    int deleteQuestionById(int id);
}
