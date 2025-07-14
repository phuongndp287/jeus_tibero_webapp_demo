package org.example.controllers;

import org.example.models.User;
import org.example.services.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignupServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (name == null || email == null || password == null || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
            return;
        }

        User user = new User(0, name, email, password); // ID is auto-generated in DB
        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            response.sendRedirect("/index.jsp?success=Account created successfully!");
        } else {
            request.setAttribute("error", "User already exists!");
            request.getRequestDispatcher("/jsp/signup.jsp").forward(request, response);
        }
    }
}
