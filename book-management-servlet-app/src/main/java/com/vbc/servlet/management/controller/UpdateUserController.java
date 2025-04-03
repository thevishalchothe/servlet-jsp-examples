package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.User;
import com.vbc.servlet.management.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UpdateUserController extends HttpServlet {
    private static final UserService userService = new UserService();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("uid"));
        User user = userService.getUserById(userId);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/views/update-user.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/ViewUserController?error=user_not_found");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                response.sendRedirect(request.getContextPath() + "/ViewUserController?updated=true");
            } else {
                request.setAttribute("errorMessage", "User update failed");
                request.getRequestDispatcher("/views/update-user.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/ViewUserController?error=invalid_id");
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("------- Inside UpdateUserController service() method ---------");
        super.service(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside UpdateUserController destroy() method ---------");
        super.destroy();
    }
}
