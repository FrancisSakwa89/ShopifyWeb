package com.franco.filters.accounts;

import com.franco.models.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/login")
public class loginFilter implements Filter {
    static int count = 0;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String username = req.getParameter("username");

        PrintWriter out=resp.getWriter();
        filterChain.doFilter(req,resp);

        out.print("<br/>Total visitors "+(++count));
        System.out.println("Total number of visitors"+" "+ (count) +" " + username);


    }

    @Override
    public void destroy() {

    }
}
