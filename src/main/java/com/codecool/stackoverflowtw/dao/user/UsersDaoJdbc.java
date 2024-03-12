package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.user.model.User;

import java.util.List;

public class UsersDaoJdbc implements UsersDao {


    @Override
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM user";

        throw new UnsupportedOperationException();
    }

    @Override
    public User getUserById() {
        String sql = "SELECT * FROM users WHERE user_id = ?";

    }
}
