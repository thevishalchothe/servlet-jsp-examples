package com.vbc.example.lifecycle;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

public class ServletLifecycle extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Servlet Initialized (init() method called)");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Request Received (service() method called)");

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>Servlet Lifecycle Example!</h2>");
        out.println("<h3>Done and Dusted! Servlet lifecycle completed.</h3>");
        out.println("<p> Now check server logs to see lifecycle messages.</p>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destroyed (destroy() method called)");
    }
}