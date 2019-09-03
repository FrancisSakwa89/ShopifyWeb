package com.franco.controller.products;

import com.franco.Bean.ProductBean;
import com.franco.controller.baseServlet;
import com.franco.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "delete-product", urlPatterns = "/delete-product")
public class deleteProductServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int id = Integer.parseInt(req.getParameter("productId"));
        try {
            Product product = new ProductBean().read(id);
            req.setAttribute("product",product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/products/deleteProduct.jsp").include(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int productId = Integer.parseInt(req.getParameter("productId"));
        try {
            Product product = new ProductBean().read(productId);
            new ProductBean().delete(product);
            PrintWriter out = new PrintWriter(System.out);
            resp.sendRedirect("all-products");
        } catch (SQLException e) {
            throw new ServletException("Error deleting product",e);

        }

    }
}
