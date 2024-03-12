package com.codecool.stackoverflowtw.dao.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record User(int id, String userName, String password, LocalDateTime registerDate) { //table colum names?
}
