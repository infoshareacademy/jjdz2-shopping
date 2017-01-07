package com.jars.shopping.LogowanieDoSystemu.Filter;

import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import com.jars.shopping.LogowanieDoSystemu.SessionData.UserDao;
import com.jars.shopping.Users.User;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
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


        String req = ((HttpServletRequest) servletRequest).getRequestURI().toLowerCase();

        System.out.println("Request from " + req);

        if (!req.contains("/login") &&
                (!req.contains("/addnewuser")) &&
                (!req.contains("/createuser")) &&
                (!req.contains("/loguser")) &&
                (!req.contains("/facebook")) &&
                (!req.contains("/twitter")) &&
                (!req.contains("/twittercallback")) &&
                (!req.equals("/")) &&
                (!req.equals("/team.jpg")) &&
                (!req.contains("/facebookcallback"))
                ) {
            if (!sessionData.isLogged()) {

                ((HttpServletResponse) servletResponse).sendRedirect("/login");

            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
