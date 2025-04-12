package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.User;
import com.vbc.servlet.management.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserController extends HttpServlet {
    private static final UserService userService = new UserService();

    // Add user
    private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String uname = request.getParameter("uname");
        String email = request.getParameter("email");

        User user = new User();
        user.setUname(uname);
        user.setEmail(email);

        boolean isAdded = userService.addUser(user);

        if (isAdded) {
            response.sendRedirect("views/add-user-success.html");
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("<html><body><h2>Failed to add user. Try again.</h2>");
            writer.println("<button onclick=\"location.href='views/add-user.html'\">Back</button>");
            writer.println("</body></html>");
        }
    }

    // View users
    private void viewUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getAllUsers();
        if (users == null || users.isEmpty()) {
            request.setAttribute("message", "No users available in the system.");
        } else {
            request.setAttribute("users", users);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/view-users.jsp");
        dispatcher.forward(request, response);
    }

    // Load update form
    private void editUserForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("uid"));
        User user = userService.getUserById(userId);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/views/update-user.jsp").forward(request, response);
        } else {
            response.sendRedirect("UserController?action=viewUsers&error=user_not_found");
        }
    }

    // Update user
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("uid"));
            String name = request.getParameter("uname");
            String email = request.getParameter("email");

            User user = new User();
            user.setUid(userId);
            user.setUname(name);
            user.setEmail(email);

            boolean isUpdated = userService.updateUser(user);

            if (isUpdated) {
                response.sendRedirect("UserController?action=viewUsers&updated=true");
            } else {
                request.setAttribute("errorMessage", "User update failed");
                request.getRequestDispatcher("/views/update-user.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("UserController?action=viewUsers&error=invalid_id");
        }
    }

    // Delete user
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("uid"));
        boolean isDeleted = userService.deleteUser(userId);

        if (isDeleted) {
            response.sendRedirect("UserController?action=viewUsers&deleted=true");
        } else {
            request.setAttribute("errorMessage", "User not found or could not be deleted");
            request.getRequestDispatcher("/views/view-users.jsp").forward(request, response);
        }
    }

    // Central dispatcher
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------ UserController: service() invoked");

        String action = request.getParameter("action");
        String method = request.getMethod();

        if ("addUser".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.addUser(request, response);
        } else if ("viewUsers".equals(action) && "GET".equalsIgnoreCase(method)) {
            this.viewUsers(request, response);
        } else if ("editUser".equals(action) && "GET".equalsIgnoreCase(method)) {
            this.editUserForm(request, response);
        } else if ("updateUser".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.updateUser(request, response);
        } else if ("deleteUser".equals(action) && "POST".equalsIgnoreCase(method)) {
            this.deleteUser(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown action: " + action);
        }
    }

    public void destroy() {
        System.out.println("------ UserController destroyed");
    }
}
