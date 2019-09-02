package com.franco.controller.customers;

import com.franco.Bean.CustomerBean;
import com.franco.models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-customers", urlPatterns = "/all-customers")
public class allCustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Customer> customers = new CustomerBean().readAll();
            req.setAttribute("customers",customers);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("views/customers/allCustomers.jsp").include(req,resp);
            req.getRequestDispatcher("/includes/footer.html").include(req,resp);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
