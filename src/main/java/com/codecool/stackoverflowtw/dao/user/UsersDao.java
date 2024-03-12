package com.codecool.stackoverflowtw.dao.user;

import com.codecool.stackoverflowtw.controller.dto.user.NewUserDto;
import com.codecool.stackoverflowtw.controller.dto.user.UserDto;
import com.codecool.stackoverflowtw.dao.user.model.User;

import java.util.List;

public interface UsersDao {
    List<User> getAllUsers();

    User getUserById(int id);

    boolean deleteUser(int id);

    boolean updateUser(int id, String userName, String password);

    int addNewUser(NewUserDto newUser);
}