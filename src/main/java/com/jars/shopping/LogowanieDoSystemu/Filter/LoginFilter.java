package com.jars.shopping.LogowanieDoSystemu.Filter;

import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import com.jars.shopping.LogowanieDoSystemu.SessionData.UserDao;
import com.jars.shopping.Users.User;

import javax.inject.Inject;
import javax.servlet.*;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Inject
    SessionData sessionData;
    @Inject
    UserDao userDao;



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        userDao.saveUserInDataBase(new User("krzysiek", "password", "InAppCreate", true));
        userDao.saveUserInDataBase(new User("niekrzysiek", "password", "InAppCreate", false));
        userDao.saveUserInDataBase(new User("nie222krzysiek", "password", "InAppCreate", false));
        userDao.saveUserInDataBase(new User("nie222kr333zysiek", "password", "InAppCreate", false));

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter !!!!");
        filterChain.doFilter(servletRequest, servletResponse);

        if (!sessionData.isLogged()) {



        }
    }

    @Override
    public void destroy() {

    }
}
