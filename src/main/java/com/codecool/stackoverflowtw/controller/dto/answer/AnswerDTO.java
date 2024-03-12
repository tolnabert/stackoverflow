package com.codecool.stackoverflowtw.controller.dto.answer;

import java.time.LocalDateTime;

public record AnswerDTO(int answer_id, String message, int user_id, int question_id, LocalDateTime submission_time) {
}
