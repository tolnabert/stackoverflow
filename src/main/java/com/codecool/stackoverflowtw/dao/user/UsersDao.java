package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.dao.user.model.User;

import java.util.List;

public interface UsersDao {
    List<User> getAllUsers();

    User getUserById(int id);
}