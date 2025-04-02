package com.vbc.servlet.management.controller;

import com.vbc.servlet.management.model.User;
import com.vbc.servlet.management.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class AddUserController extends HttpServlet {
    private static final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String uname = request.getParameter("uname");
        String email = request.getParameter("email");

        User user = new User();
        user.setUname(uname);
        user.setEmail(email);

        boolean isAdded = userService.addUser(user);

        if (isAdded) {
            response.sendRedirect("add-user-success.html");
        } else {
            PrintWriter writer = response.getWriter();
            writer.println("<html><body><h2>Failed to add user. Try again.</h2>");
            writer.println("<button onclick=\"location.href='add-user.html'\">Back</button>");
            writer.println("</body></html>");
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("------- Inside the service() method ---------");
        this.doPost(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
    }
}
