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

    @PostMapping("/login")
    public int loginUser(@RequestBody NewUserDto userDto) {
        return userService.logInUser(userDto);
    }

    @PostMapping("/")
    public int addNewUser(@RequestBody NewUserDto user) {
        return userService.addNewUser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @PatchMapping("/{id}")
    public boolean updateUserById(@PathVariable int id, @RequestBody UserDto user) {
        return userService.updateUser(id, user);
    }
}