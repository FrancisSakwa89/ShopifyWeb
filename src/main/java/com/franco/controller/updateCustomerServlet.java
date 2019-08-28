package com.franco.controller;

import com.franco.Bean.CustomerBean;
import com.franco.Bean.ProductBean;
import com.franco.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name ="update-customer", urlPatterns = "/update-customer")
public class updateCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("userId"));
        String customerName = req.getParameter("name");
        CustomerBean customerBean = new CustomerBean();
        try {
            Customer customer = new CustomerBean().read(userId);

            customer.setName(customerName);
            new CustomerBean().update(customer);
            resp.sendRedirect("index.jsp");
//            productBean.update(productName,productDescription));
        } catch (SQLException e) {
            throw new ServletException("Error updating customer",e);
        }
    }
    }

