package com.codecool.stackoverflowtw.dao.questioon;

import com.codecool.stackoverflowtw.DataBase;
import com.codecool.stackoverflowtw.dao.questioon.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {

    @Override
    public List<Question> getAllQuestions() {
        // TODO SQL query questions from database
        List<Question> questions = new ArrayList<>();

        var sql = "SELECT question_id, title, description, creation_date FROM questions";

        try (var conn = DataBase.connect()) {
            assert conn != null;
            try (var stmt = conn.createStatement()) {

                var rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    var product = new Question(
                            rs.getInt("question_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getTimestamp("creation_date").toLocalDateTime());
                    questions.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
