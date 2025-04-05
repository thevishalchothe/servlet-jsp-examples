package com.vbc.servlet.management.service;

import com.vbc.servlet.management.model.User;
import com.vbc.servlet.management.repository.UserRepository;

import java.util.List;

public class UserService {
    private static final UserRepository userRepository = new UserRepository();

    public boolean addUser(User user) {
        return userRepository.addUser(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public boolean deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }

    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }

    public boolean updateUser(User user) {
        return userRepository.updateUser(user);
    }
}
