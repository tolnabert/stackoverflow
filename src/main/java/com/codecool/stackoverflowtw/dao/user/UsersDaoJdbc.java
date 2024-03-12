package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.DataBase;
import com.codecool.stackoverflowtw.controller.dto.user.NewUserDto;
import com.codecool.stackoverflowtw.dao.user.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UsersDaoJdbc implements UsersDao {

    public static final String SELECT_ALL_USERS = "SELECT * FROM users";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE user_id = ?";
    public static final String ADD_NEW_USER = "INSERT INTO users (user_name, user_password, register_date) VALUES (?, ?, ?)";
    public static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id = ?";
    public static final String UPDATE_USER_BY_ID = "UPDATE users SET user_name = ?, user_password = ? WHERE user_id = ?";

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL_USERS)) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                User user = new User(
                        rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getString("user_password"),
                        rs.getTimestamp("register_date").toLocalDateTime()
                );
                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(int id) {
        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_USER_BY_ID)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return new User(
                    rs.getInt("user_id"),
                    rs.getString("user_name"),
                    rs.getString("user_password"),
                    rs.getTimestamp("register_date").toLocalDateTime()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new NoSuchElementException("No user found with ID: " + id);
    }

    @Override
    public int addNewUser(NewUserDto newUser) {
        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(ADD_NEW_USER)) {

            pstmt.setString(1, newUser.userName());
            pstmt.setString(2, newUser.password());

            return pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean updateUser(int id, String userName, String password) {
        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(UPDATE_USER_BY_ID)) {

            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        try (Connection conn = DataBase.connect();
             PreparedStatement pstmt = conn.prepareStatement(DELETE_USER_BY_ID)) {

            pstmt.setInt(1, id);

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
