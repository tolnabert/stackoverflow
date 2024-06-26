package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.question.QuestionDTO;
import com.codecool.stackoverflowtw.dao.questioon.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.questioon.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionsDAO questionsDAO;
    @Autowired
    public QuestionService(QuestionsDAO questionsDAO) {
        this.questionsDAO = questionsDAO;
    }

    public List<QuestionDTO> getAllQuestions() {
        List<Question> allQuestions = questionsDAO.getAllQuestions();
        List<QuestionDTO> convertedQuestions = new ArrayList<>();
        for (Question question : allQuestions) {
            convertedQuestions.add(new QuestionDTO(question.question_id(), question.title(), question.description(), question.user_id(), question.creation_date()));
        }
        return convertedQuestions;
    }

    public QuestionDTO getQuestionById(int id) {
        Question question = questionsDAO.getQuestionById(id);
        System.out.println(question);
        return new QuestionDTO(question.question_id(), question.title(), question.description(), question.user_id(), question.creation_date());
    }
    public int addNewQuestion(NewQuestionDTO question) {
        questionsDAO.addNewQuestion(question);
        return 0;
    }
    public boolean deleteQuestionById(int id) {
        questionsDAO.deleteQuestionById(id);
        return true;
    }
}
