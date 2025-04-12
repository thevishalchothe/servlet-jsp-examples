package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.Admin;
import com.vbc.servlet.management.service.AdminService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminController extends HttpServlet {
    private static final AdminService adminService = new AdminService();

    // Handle admin registration
    private void registerAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            // Registration failed, show error message
            response.setContentType("text/html");
            response.getWriter().println("<h2 style='color:red;'>Registration Failed!</h2>");
        }
    }

    // Handle admin login
    private void loginAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminService.loginAdmin(username, password);

        if (admin != null) {
            // Optional: set admin in session
            request.getSession().setAttribute("loggedInAdmin", admin);

            // Redirect to admin homepage with login success
            response.sendRedirect("views/admin-homepage.html?login=success");
        } else {
            // Login failed, redirect back with error
            response.sendRedirect("views/login-admin.html?error=true");
        }
    }

    // Central dispatcher to handle actions
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------------- AdminController in service...");

        String action = request.getParameter("action");
        String method = request.getMethod();

        if ("register".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.registerAdmin(request, response);
        } else if ("login".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.loginAdmin(request, response);
        } else if ("register".equals(action) && "GET".equalsIgnoreCase(method)) {
            request.getRequestDispatcher("views/register-admin.html").forward(request, response);
        } else if ("login".equals(action) && "GET".equalsIgnoreCase(method)) {
            request.getRequestDispatcher("views/login-admin.html").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown action: " + action);
        }
    }

    public void destroy() {
        System.out.println("------------- AdminController destroyed...");
    }
}
