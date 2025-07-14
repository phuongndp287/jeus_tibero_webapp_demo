package org.example.controllers;

import org.example.models.Product;
import org.example.services.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DashboardServlet extends HttpServlet {

    private ProductService productService;
    @Override
    public void init() throws ServletException {
        productService = new ProductService(); // Initialize the ProductService
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }
        List<Product> products = productService.getAllProducts();
        request.setAttribute("products", products); // Gửi danh sách product sang JSP

        request.getRequestDispatcher("/jsp/dashboard.jsp").forward(request, response);
    }
}
