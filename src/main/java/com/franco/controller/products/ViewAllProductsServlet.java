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
import java.util.ArrayList;



@WebServlet(name = "all-products", urlPatterns = "/all-products")
public class ViewAllProductsServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        try {
            ArrayList<Product> products = new ProductBean().readAll();
            req.setAttribute("products",products);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("views/products/products.jsp").include(req,resp);
            req.getRequestDispatcher("/includes/footer.html").include(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
