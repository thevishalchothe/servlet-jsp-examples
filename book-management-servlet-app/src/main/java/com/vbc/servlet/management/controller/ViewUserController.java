package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.User;
import com.vbc.servlet.management.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ViewUserController extends HttpServlet {
    private static final UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<User> users = userService.getAllUsers();

        if (users == null || users.isEmpty()) {
            request.setAttribute("message", "No users available in the system.");
        } else {
            request.setAttribute("users", users);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view-users.jsp");
        dispatcher.forward(request, response);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------- Inside the service() method ---------");
        doGet(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
    }
}
