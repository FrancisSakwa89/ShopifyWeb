package com.franco.filters.recievings;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/recievings")
public class recieveFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        int id = Integer.parseInt(req.getParameter("id"));
//        try{
////            if (resp){
////
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @Override
    public void destroy() {

    }
}
