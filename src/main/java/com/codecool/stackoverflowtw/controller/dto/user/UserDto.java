package com.codecool.stackoverflowtw.controller.dto.user;

import java.time.LocalDateTime;

public record UserDto(int id, String userName, String password, LocalDateTime registerDate) {
}
