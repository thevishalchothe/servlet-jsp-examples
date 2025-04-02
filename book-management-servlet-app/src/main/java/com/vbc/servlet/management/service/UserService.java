package com.vbc.servlet.management.service;

import com.vbc.servlet.management.db.DBConnection;
import com.vbc.servlet.management.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT uid, uname, email FROM users";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
