package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DeleteUserController extends HttpServlet {
    private static final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("uid"));
        boolean isDeleted = userService.deleteUser(userId);

        if (isDeleted) {
            // Redirect to ViewUserController with success parameter
            response.sendRedirect(request.getContextPath() + "/ViewUserController?deleted=true");
        } else {
            request.setAttribute("errorMessage", "User not found or could not be deleted");
            request.getRequestDispatcher("/view-users.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("------- Inside DeleteUserController service() method ---------");
        super.service(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("------- Inside DeleteUserController destroy() method ---------");
        super.destroy();
    }
}
