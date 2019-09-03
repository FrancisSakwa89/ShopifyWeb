package com.franco.controller.recievings;

import com.franco.Bean.RecieveBean;
import com.franco.controller.baseServlet;
import com.franco.models.Recievings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet(name = "add-recieving",urlPatterns = "/add-recieving")
public class addRecievingServlet extends baseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        validate(req,resp);
        int batchNo = Integer.parseInt(req.getParameter("batch_no"));
        Date date = new Date();
        double selling_price = Integer.parseInt(req.getParameter("selling_price"));
        double buying_price = Integer.parseInt(req.getParameter("buying_price"));
        int productId = Integer.parseInt(req.getParameter("productId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String supplier = req.getParameter("supplier");
        int runningBalance = quantity;


        try {
            RecieveBean recieveBean =new RecieveBean();
            recieveBean.create(new Recievings(batchNo, date, productId, quantity, buying_price, selling_price, supplier,runningBalance));
            resp.sendRedirect("home.jsp");
        } catch (SQLException e) {
            throw new ServletException("Error creating product",e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        validate(req,resp);
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("/views/recievings/addRecievings.jsp").include(req,resp);

    }
}
