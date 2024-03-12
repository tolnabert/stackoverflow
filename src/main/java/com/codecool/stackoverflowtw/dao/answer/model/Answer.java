package com.codecool.stackoverflowtw.dao.answer.model;

import java.time.LocalDateTime;

public record Answer(int answer_id,
                     String message,
                     int user_id,
                     int question_id,
                     LocalDateTime submission_time) { }