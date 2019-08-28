package com.franco.controller;

import com.franco.Bean.CustomerBean;
import com.franco.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name ="add-customer", urlPatterns = "/add-customer")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        CustomerBean customerBean = new CustomerBean();
        try {
            customerBean.create(new Customer(name));
            resp.sendRedirect("index.jsp");
        }  catch (SQLException e) {
            throw new ServletException("Error creating customer",e);
        }

    }
}
