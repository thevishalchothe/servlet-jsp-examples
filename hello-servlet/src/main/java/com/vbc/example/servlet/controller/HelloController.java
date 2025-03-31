package com.vbc.example.servlet.controller;

import com.vbc.example.servlet.service.HelloService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloController extends HttpServlet {

    // Creating an instance of HelloService to use its methods for generating responses
    private static final HelloService helloService = new HelloService();

    // Handles HTTP GET requests, and This method is called when a GET request is sent to the servlet.
    // It generates an HTML response with a greeting message.
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("------- Inside the doGet() method ---------");

        // Setting the response content type to HTML
        response.setContentType("text/html");

        // Writing the HTML response
        PrintWriter writer = response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + helloService.greet() + "</h1>"); // Calling greet() method from HelloService
        writer.println("</body></html>");
    }


    // When request is receive, service() method is called automatically.
    // However, in this case, we override it to explicitly call doGet() for every request.
    // Overriding service() manually is not needed, as HttpServlet already provides a default service() implementation.
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("------- Inside the service() method ---------");
        this.doGet(request, response); // Forwarding request to doGet()
    }


    // When the servlet is being removed from memory, destroy() method is called.
    // This happens when the server stops or when the application is redeployed.
    // It is used to release resources like database connections, file handles, etc.
    public void destroy() {
        System.out.println("------- Inside the destroy() method ---------");
        // Cleanup logic (if needed)
    }

}
