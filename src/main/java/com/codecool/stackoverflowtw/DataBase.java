package com.codecool.stackoverflowtw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public static Connection connect() throws SQLException {

        try {
            // Get database credentials from DatabaseConfig class
            var jdbcUrl = System.getenv("POSTGRES_URL");
            var user = System.getenv("POSTGRES_USER");
            var password = System.getenv("POSTGRES_PASSWORD");
            // Open a connection
            return DriverManager.getConnection(jdbcUrl, user, password);

        } catch (SQLException  e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
