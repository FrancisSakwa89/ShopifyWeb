package com.franco.controller;

import com.franco.Bean.ProductBean;
import com.franco.Bean.RecieveBean;
import com.franco.models.Product;
import com.franco.models.Recievings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-products", urlPatterns = "/all-products")
public class ViewAllProductsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Product> products = new ProductBean().readAll();
            req.setAttribute("products",products);
            req.getRequestDispatcher("all-products.jsp").forward(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
