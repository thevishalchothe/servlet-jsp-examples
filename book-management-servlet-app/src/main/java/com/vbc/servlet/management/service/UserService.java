package com.vbc.servlet.management.service;

import com.vbc.servlet.management.db.DBConnection;
import com.vbc.servlet.management.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    public boolean addUser(User user) {
        boolean result = false;
        String sql = "INSERT INTO users (uname, email) VALUES (?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            result = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
