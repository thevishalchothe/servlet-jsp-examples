package com.vbc.example.servlet.controller;

import com.vbc.example.servlet.service.HelloService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloController extends HttpServlet {

    private static final HelloService helloService = new HelloService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("------- Inside the doGet() method ---------");

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String occasion = request.getParameter("occasion");
        String message = request.getParameter("message");

        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + helloService.greet(name, occasion, message) + "</h1>");
        writer.println("</body></html>");
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("------- Inside the service() method ---------");
        this.doGet(request, response);
    }

    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
    }

}
