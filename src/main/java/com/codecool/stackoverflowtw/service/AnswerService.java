package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.dao.answer.AnswersDAO;
import com.codecool.stackoverflowtw.dao.answer.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswersDAO answersDAO;

    @Autowired
    public AnswerService(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }

    public List<AnswerDTO> getAllAnswersForQuestion(int question_id) {
        List<Answer> answers = answersDAO.getAllAnswersForQuestion(question_id);
        return answers.stream().map(answer -> new AnswerDTO(
                answer.answer_id(),
                answer.message(),
                answer.user_id(),
                answer.question_id(),
                answer.submission_time())).collect(Collectors.toList());
    }
}