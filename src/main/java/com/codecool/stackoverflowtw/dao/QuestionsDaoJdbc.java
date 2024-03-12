package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.DataBase;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class QuestionsDaoJdbc implements QuestionsDAO {

    @Override
    public List<Question> getAllQuestions() {
        // TODO SQL query questions from database
        List<Question> questions = new ArrayList<>();

        var sql = "SELECT question_id, title, description, creation_date FROM questions";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public Question getQuestionById(int id) {
        var sql = "SELECT question_id, title, description, creation_date FROM questions WHERE question_id=?";

        try (var conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return new Question(
                            rs.getInt("question_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getTimestamp("creation_date").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int addNewQuestion(NewQuestionDTO question) {
        var sql = "INSERT INTO questions(title, description) "
                + "VALUES(?,?)";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                // bind the values
                pstmt.setString(1, question.title());
                pstmt.setString(2, question.description());

                // execute the INSERT statement and get the inserted id
                int insertedRow = pstmt.executeUpdate();
                if (insertedRow > 0) {
                    ResultSet rs = pstmt.getGeneratedKeys();
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int deleteQuestionById(int id) {
        var sql = "DELETE FROM questions WHERE id=?";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                return pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
