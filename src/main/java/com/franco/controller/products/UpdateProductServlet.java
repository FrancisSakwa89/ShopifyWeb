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
import java.sql.SQLException;

@WebServlet(name ="update-product", urlPatterns = "/update-product")
public class UpdateProductServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int id = Integer.parseInt(req.getParameter("prod uctId"));
        try {
            Product product = new ProductBean().read(id);
            req.setAttribute("product",product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/products/updateProduct.jsp").include(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int ProductId = Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("name");
        String productDescription = req.getParameter("description");
        ProductBean productBean = new ProductBean();

        try {
           Product product = new ProductBean().read(ProductId);

            product.setName(productName);
            product.setDescription(productDescription);
            new ProductBean().update(product);
            resp.sendRedirect("all-products");
//            productBean.update(productName,productDescription));
        } catch (SQLException e) {
            throw new ServletException("Error updating product",e);
        }
    }
}