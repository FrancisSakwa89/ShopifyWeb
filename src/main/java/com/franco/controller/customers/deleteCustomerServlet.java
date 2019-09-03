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

@WebServlet(name ="delete-customer", urlPatterns = "/delete-customer")
public class deleteCustomerServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int userId = Integer.parseInt(req.getParameter("userId"));
        try {
            Customer customer = new CustomerBean().read(userId);
            req.setAttribute("customer",customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/customers/deleteCustomer.jsp").include(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int userId = Integer.parseInt(req.getParameter("userId"));
        CustomerBean customerBean = new CustomerBean();
        try {
            Customer customer = new CustomerBean().read(userId);
            new CustomerBean().delete(customer);
            resp.sendRedirect("all-customers");
//            productBean.update(productName,productDescription));
        } catch (SQLException e) {
            throw new ServletException("Error deleting customer",e);
        }

    }
}
