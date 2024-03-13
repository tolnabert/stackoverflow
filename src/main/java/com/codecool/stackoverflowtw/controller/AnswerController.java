package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.answer.AnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/{questionId}")
    public boolean postNewAnswer(@PathVariable int questionId, @RequestBody NewAnswerDTO answerDTO) {
        return answerService.postNewAnswer(questionId, answerDTO);
    }

    @GetMapping("/{id}")
    public AnswerDTO getAnswerById(@PathVariable int id) {
        return answerService.getAnswer(id);
    }

    @PatchMapping("/{id}")
    public boolean updateAnswerById(@PathVariable int id, @RequestBody AnswerDTO answer) {
        return answerService.updateAnswerById(id, answer.message());
    }

    @DeleteMapping("/{userId}/{answerId}")
    public boolean deleteAnswerById(@PathVariable int userId, @PathVariable int answerId) {
        return answerService.deleteAnswerById(userId, answerId);
    }
}