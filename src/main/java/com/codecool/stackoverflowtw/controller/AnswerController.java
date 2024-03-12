package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import com.codecool.stackoverflowtw.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/answer")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/{id}/all")
    public List<AnswerDTO> getAllAnswersForQuestion(@PathVariable int id) {
        return answerService.getAllAnswersForQuestion(id);
    }

    @GetMapping("/{id}")
    public AnswerDTO getAnswerById(@PathVariable int id) {
        return answerService.getAnswer(id);
    }

    @PatchMapping("/{id}")
    public boolean updateAnswerById(@PathVariable int id, @RequestBody AnswerDTO answer) {
        return answerService.updateAnswerById(id, answer.message());
    }

    //TODO the rest based on question service

//        @PostMapping("/")
//        public int addNewQuestion(@RequestBody NewQuestionDTO question) {
//            return answerService.addNewQuestion(question);
//        }
//
//        @DeleteMapping("/{id}")
//        public boolean deleteQuestionById(@PathVariable int id) {
//            return answerService.deleteQuestionById(id);
//        }
}