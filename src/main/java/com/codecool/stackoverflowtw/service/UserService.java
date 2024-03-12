package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.user.UserDto;
import com.codecool.stackoverflowtw.dao.user.UsersDao;
import com.codecool.stackoverflowtw.dao.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UsersDao usersDao;

    @Autowired
    public UserService(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = usersDao.getAllUsers();

        return allUsers.stream()
                .map(user -> new UserDto(user.id(), user.userName(), user.password(), user.registerDate()))
                .collect(Collectors.toList());
    }

    public UserDto getUserById() {
        User user = usersDao.getUserById();

        return new UserDto(user.id(), user.userName(), user.password(), user.registerDate());
    }
}
