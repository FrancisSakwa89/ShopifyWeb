package com.franco.controller;

import com.franco.Bean.UserBean;
import com.franco.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class baseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();
        User user = new User(name,password);
        HttpSession s = req.getSession();
        s.setAttribute("username",user);
        resp.sendRedirect("home.jsp");

    }

    public boolean isLoggedIn(HttpServletRequest req){
        HttpSession s = req.getSession();
        return (boolean)s.getAttribute("loggedIn");


    }

    public void auth(HttpServletRequest req){
        HttpSession s = req.getSession();
        s.setAttribute("loggedIn", true);

    }
}
