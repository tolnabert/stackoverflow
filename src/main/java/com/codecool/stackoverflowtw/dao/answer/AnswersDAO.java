package com.codecool.stackoverflowtw.dao.answer;

import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.answer.model.Answer;

import java.util.List;

public interface AnswersDAO {

    List<Answer> getAllAnswersForQuestion(int question_id);

    Answer getAnswer(int answer_id);

    boolean updateAnswerById(int answer_id, String message);

    boolean postNewAnswer(int id, NewAnswerDTO answerDTO);

    boolean deleteAnswerById(int userId, int answerId);
}
