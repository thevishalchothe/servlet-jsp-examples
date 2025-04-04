package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Admin;
import com.vbc.servlet.management.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginAdminController extends HttpServlet {
    private static final AdminService adminService = new AdminService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/login-admin.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminService.loginAdmin(username, password);

        if (admin != null) {
            // Optional: set admin in session
            request.getSession().setAttribute("loggedInAdmin", admin);

            // Redirect to admin homepage with login success
            response.sendRedirect("views/admin-homepage.html?login=success");
        } else {
            // Redirect back to login with error
            response.sendRedirect("views/login-admin.html?error=true");
        }
    }
}
