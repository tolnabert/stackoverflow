package com.codecool.stackoverflowtw.controller.dto.question;

import java.time.LocalDateTime;

public record QuestionDTO(int question_id, String title, String description, int user_id, LocalDateTime creation_date) {}
