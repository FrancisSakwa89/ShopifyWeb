package com.franco.controller;

import com.franco.Bean.ProductBean;
import com.franco.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "delete-product", urlPatterns = "delete-product")
public class deleteProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        try {
            Product product = new ProductBean().read(productId);
            new ProductBean().delete(product);
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error deleting product",e);

        }

    }
}
