package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.user.NewUserDto;
import com.codecool.stackoverflowtw.controller.dto.user.UserDto;
import com.codecool.stackoverflowtw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/")
    public int addNewUser(@RequestBody NewUserDto user) {
//        TODO
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id) {
//        TODO
        throw new UnsupportedOperationException();
    }
}
