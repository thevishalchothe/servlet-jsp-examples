package com.vbc.example.servlet.service;

public class HelloService {
    public String greet(String name, String occasion, String message) {
        return "Hello, " + name + "! Wishing you a wonderful " + occasion + ".<br><br>Message: " + message;
    }
}
