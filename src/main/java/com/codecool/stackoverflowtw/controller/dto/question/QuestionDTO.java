package com.codecool.stackoverflowtw.controller.dto.question;

import java.time.LocalDateTime;

public record QuestionDTO(int question_id, String title, String description, LocalDateTime creation_date) {}
