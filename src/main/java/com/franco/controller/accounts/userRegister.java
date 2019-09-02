package com.franco.controller.accounts;

import com.franco.Bean.UserBean;
import com.franco.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "add-user", urlPatterns = "/add-user")
public class userRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();

        try {
            userBean.create(new User(name,password));
            resp.sendRedirect("index.jsp");
        } catch (SQLException e) {
           throw new ServletException("Error creating user "+ e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
