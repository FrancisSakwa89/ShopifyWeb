package com.franco.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.html").forward(req,resp);

        /*Cookie cookie = new Cookie("name","Francis");
        Cookie ck[]=req.getCookies();
        for(int i=0;i<ck.length;i++){
            System.out.println("<br>"+ck[i].getName()+" "+ck[i].getValue());//printing name and value of cookie
            if (ck[i].getValue().equalsIgnoreCase("Francis")){
                System.out.println("cookie exists...."+ " "+ ck[i].getValue());
            }else resp.addCookie(cookie);
        }*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
