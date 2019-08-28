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

@WebServlet(name ="update-product", urlPatterns = "/update-product")
public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int ProductId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("name");
        String productDescription = req.getParameter("description");
        ProductBean productBean = new ProductBean();
        try {
           Product product = new ProductBean().read(ProductId);

            product.setName(productName);
            product.setDescription(productDescription);
            new ProductBean().update(product);
            resp.sendRedirect("index.jsp");
//            productBean.update(productName,productDescription));
        } catch (SQLException e) {
            throw new ServletException("Error updating product",e);
        }
    }
}