package org.example.controllers;

import org.example.models.User;
import org.example.services.UserService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "Email and Password are required!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        User user = userService.loginUser(email, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("dashboard"); // Redirect to dashboard Servlet
        } else {
            request.setAttribute("error", "Invalid credentials!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}