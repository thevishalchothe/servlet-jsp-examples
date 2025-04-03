package com.vbc.servlet.management.service;

import com.vbc.servlet.management.dao.UserDAO;
import com.vbc.servlet.management.model.User;

import java.util.List;

public class UserService {
    private static final UserDAO userDAO = new UserDAO();

    public boolean addUser(User user) {
        return userDAO.addUser(user);
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean deleteUser(int userId) {
        return userDAO.deleteUser(userId);
    }

    public User getUserById(int userId) {
        return userDAO.getUserById(userId);
    }

    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
