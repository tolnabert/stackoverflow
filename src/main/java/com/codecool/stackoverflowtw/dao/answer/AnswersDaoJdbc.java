package com.codecool.stackoverflowtw.dao.answer;

import com.codecool.stackoverflowtw.DataBase;
import com.codecool.stackoverflowtw.controller.dto.answer.NewAnswerDTO;
import com.codecool.stackoverflowtw.dao.answer.model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswersDaoJdbc implements AnswersDAO {
    @Override
    public List<Answer> getAllAnswersForQuestion(int question_id) {
        List<Answer> answers = new ArrayList<>();

        var sql = "SELECT a.answer_id, a.message, a.user_id, a.question_id, a.submission_time " +
                "FROM answers a " +
                "WHERE a.question_id = ? " +
                "ORDER BY a.submission_time";

        try (Connection conn = DataBase.connect()) {
            if (conn == null) {
                return null;
            }
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, question_id);
                var rs = stmt.executeQuery();

                while (rs.next()) {
                    var answer = new Answer(
                            rs.getInt("answer_id"),
                            rs.getString("message"),
                            rs.getInt("user_id"),
                            rs.getInt("question_id"),
                            rs.getTimestamp("submission_time").toLocalDateTime());
                    answers.add(answer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;

    }

    @Override
    public Answer getAnswer(int answer_id) {
        Answer answer = null;

        var sql = "SELECT answer_id, message, user_id, question_id, submission_time FROM answers " +
                "WHERE answer_id = ?";

        try (Connection conn = DataBase.connect()) {
            if (conn == null) {
                return null;
            }
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, answer_id);

                var rs = stmt.executeQuery();

                if (rs.next()) {
                    answer = new Answer(
                            rs.getInt("answer_id"),
                            rs.getString("message"),
                            rs.getInt("user_id"),
                            rs.getInt("question_id"),
                            rs.getTimestamp("submission_time").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @Override
    public boolean updateAnswerById(int answer_id, String message) {
        var sql = "UPDATE answers SET " +
                "message = ? " +
                "WHERE answer_id = ?";

        try (Connection conn = DataBase.connect()) {
            if (conn == null) {
                return false;
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, message);
                pstmt.setInt(2, answer_id);

                int rs = pstmt.executeUpdate();
                return rs > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean postNewAnswer(int id, NewAnswerDTO answerDTO) {
        //String message, int user_id, int question_id
        String sql = "INSERT INTO answers(message, user_id, question_id) " +
                "VALUES (?, ?, ?);";


        try (Connection conn = DataBase.connect()) {
            if (conn == null) {
                return false;
            }
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, answerDTO.message());
                pstmt.setInt(2, answerDTO.user_id());
                pstmt.setInt(3, answerDTO.question_id());

                int rs = pstmt.executeUpdate();
                return rs > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
