package com.franco.controller.sale;


import com.franco.Bean.SaleBean;
import com.franco.models.Sale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "all-sales", urlPatterns = "/all-sales")
public class allSalesServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Sale> sales = new SaleBean().readAll();
            req.setAttribute("sales",sales);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("/views/sale/allSales.jsp").include(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }

