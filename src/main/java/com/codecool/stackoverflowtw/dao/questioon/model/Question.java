package com.codecool.stackoverflowtw.dao.questioon.model;

import java.time.LocalDateTime;

public record Question(int question_id, String title, String description, int user_id, LocalDateTime creation_date) {
}
