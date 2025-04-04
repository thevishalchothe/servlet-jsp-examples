package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Admin;
import com.vbc.servlet.management.service.AdminService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterAdminController extends HttpServlet {
    private static final AdminService adminService = new AdminService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/register-admin.html").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = request.getParameter("adminName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = new Admin();
        admin.setAdminName(adminName);
        admin.setUsername(username);
        admin.setPassword(password);

        boolean isRegistered = adminService.registerAdmin(admin);
        if (isRegistered) {
            // Redirect to login page with success message
            response.sendRedirect("views/login-admin.html?success=true");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h2 style='color:red;'>Registration Failed!</h2>");
        }
    }
}
