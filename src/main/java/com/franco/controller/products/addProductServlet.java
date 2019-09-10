package com.franco.controller.products;

import com.franco.Bean.ProductBean;
import com.franco.Bean.RecieveBean;
import com.franco.controller.baseServlet;
import com.franco.models.Product;
import com.franco.models.Recievings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "add-product", urlPatterns = "/add-product")
public class addProductServlet extends baseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        req.getRequestDispatcher("/views/products/addProduct.jsp").forward(req,resp);
//        throw new RuntimeException("test exception");

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            ProductBean productBean = new ProductBean();
            try {
                productBean.create(new Product(name, description));
                resp.sendRedirect("all-products");
            } catch (SQLException e) {
                throw new ServletException("Error creating product", e);
            }



        }
    }




