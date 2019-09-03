package com.franco.controller.sale;

import com.franco.Bean.*;
import com.franco.controller.baseServlet;
import com.franco.models.Customer;
import com.franco.models.Recievings;
import com.franco.models.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name ="add-sale", urlPatterns = "/add-sale")
public class addSaleServlet extends baseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/sale/addSale.jsp").include(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int UserId = Integer.parseInt(req.getParameter("UserId"));
        RecieveBean recieveBean = new RecieveBean();
        SaleBean saleBean = new SaleBean();
        String customerName = null;
        try {
            customerName = new CustomerBean().read(UserId).getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int sellingPrice = 0;
        try {
            sellingPrice = (int) new RecieveBean().read(productId).getSellingPrice();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int runningBalance = 0;
        try {
            runningBalance = new RecieveBean().read(productId).getRunningBalance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        double totalAmount = quantity * sellingPrice;
        java.util.Date datetime = new java.util.Date();
        try {
            saleBean.create(new Sale(datetime, productId, quantity, customerName, sellingPrice, runningBalance, totalAmount));
            resp.sendRedirect("all-sales");
        } catch (SQLException e) {
            throw new ServletException("Error creating sale", e);
        }


    }
}