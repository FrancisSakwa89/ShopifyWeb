package com.franco.controller;

import com.franco.Bean.CustomerBean;
import com.franco.Bean.ProductBean;
import com.franco.Bean.RecieveBean;
import com.franco.Bean.SaleBean;
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
public class SaleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int UserId = Integer.parseInt(req.getParameter("UserId"));
        RecieveBean recieveBean = new RecieveBean();
        SaleBean saleBean = new SaleBean();
        java.util.Date datetime = new java.util.Date();
        int sellingPrice = 0;
        try {
            sellingPrice = (int) recieveBean.read(productId).getSellingPrice();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {

            Customer customer = new CustomerBean().read(UserId);
            if (CustomerBean.isCustomerExists(UserId) && recieveBean.isRecievingExists(productId)) {
                if (recieveBean.read(productId).getQuantity() > quantity) {
                    String customerName = customer.getName();

                    Sale sale = new SaleBean().read(productId);
                    try {
                        int runningBalance;

                        runningBalance = recieveBean.read(productId).setQuantity(sale.setRunningBalance(recieveBean.read(productId).getQuantity()) - (quantity));
                        double totalAmount = recieveBean.read(productId).getSellingPrice() * quantity;
                        saleBean.create(new Sale(datetime, productId, quantity, customerName, sellingPrice, runningBalance, totalAmount));
                        resp.sendRedirect("index.jsp");
                    } catch (SQLException e) {
                        throw new ServletException("Error creating customer", e);
                    }

                }
            }else throw new ServletException("Unable to create sale...");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}