package com.franco.controller.customers;

import com.franco.Bean.CustomerBean;
import com.franco.controller.baseServlet;
import com.franco.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name ="add-customer", urlPatterns = "/add-customer")
public class CustomerServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/customers/addCustomer.jsp").include(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        String name = req.getParameter("name");

        CustomerBean customerBean = new CustomerBean();
        try {
            customerBean.create(new Customer(name));
            resp.sendRedirect("all-customers");
        }  catch (SQLException e) {
            throw new ServletException("Error creating customer",e);
        }

    }
}
