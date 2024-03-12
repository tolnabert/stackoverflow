package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.util.List;

public interface QuestionsDAO {
    List<Question> getAllQuestions();
    Question getQuestionById(int id);
    int addNewQuestion(NewQuestionDTO question);
    int deleteQuestionById(int id);
    //int updateQuestionById(int id, String title, String description);
}
