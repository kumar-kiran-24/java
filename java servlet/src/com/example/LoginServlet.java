package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        if ("admin".equals(username) && "admin123".equals(password)) {
            out.println("<html><body><h1>Login Successful!</h1></body></html>");
        } else {
            out.println("<html><body><h1>Login Failed!</h1></body></html>");
        }

        out.close();
    }
}
