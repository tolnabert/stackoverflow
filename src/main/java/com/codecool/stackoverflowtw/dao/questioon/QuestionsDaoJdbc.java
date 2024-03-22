package com.codecool.stackoverflowtw.dao.questioon;

import com.codecool.stackoverflowtw.DataBase;
import com.codecool.stackoverflowtw.controller.dto.question.NewQuestionDTO;
import com.codecool.stackoverflowtw.dao.questioon.model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionsDaoJdbc implements QuestionsDAO {

    @Override
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();

        var sql = "SELECT question_id, title, description, user_id,  creation_date FROM questions";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    var product = new Question(
                            rs.getInt("question_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getInt("user_id"),
                            rs.getTimestamp("creation_date").toLocalDateTime());
                    questions.add(product);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    @Override
    public Question getQuestionById(int id) {
        String sql = "SELECT question_id, title, description, user_id, creation_date FROM questions WHERE question_id=?";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, id);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    return new Question(
                            rs.getInt("question_id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getInt("user_id"),
                            rs.getTimestamp("creation_date").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addNewQuestion(NewQuestionDTO question) {
        System.out.println(question);
        String sql = "INSERT INTO questions(title, description, user_id) "
                + "VALUES(?,?,?)";

        try (Connection conn = DataBase.connect()) {
            assert conn != null;
            try (PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                pstmt.setString(1, question.title());
                pstmt.setString(2, question.description());
                pstmt.setInt(3, question.userId());

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
        String sql = "DELETE FROM questions WHERE user_id=?";

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
