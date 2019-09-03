package com.franco.controller.accounts;


import com.franco.Bean.UserBean;
import com.franco.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/includes/navbar.jsp").include(req,resp);
        req.getRequestDispatcher("index.jsp").include(req,resp);
        req.getRequestDispatcher("/includes/footer.html").include(req,resp);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        UserBean userBean = new UserBean();
        try {
            User user = userBean.readByName(name);
            if(user.getPassword().equalsIgnoreCase(password)){
                auth(req);
                HttpSession s = req.getSession();
                s.setAttribute("username",user);
                resp.sendRedirect("home.jsp");


            }

//           else if (isLoggedIn(req)) {
//                // the user is already logged in and he's trying to login again
//                // then forward to the homepage
//                req.getRequestDispatcher("home.jsp").forward(req, resp);
//            }
            else {
                req.setAttribute("message", "User doesn't exist");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }

        } catch (SQLException e) {
            throw new ServletException("Error creating user", e);
        }
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
