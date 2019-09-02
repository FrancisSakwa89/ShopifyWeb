package com.franco.controller.recievings;

import com.franco.Bean.RecieveBean;
import com.franco.models.Recievings;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(name = "all-recievings", urlPatterns = "/all-recievings")
public class allRecievingsServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<Recievings> recievings = new RecieveBean().readAll();
            req.setAttribute("recievings",recievings);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
            req.getRequestDispatcher("views/recievings/allRecievings.jsp").include(req,resp);
            req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
