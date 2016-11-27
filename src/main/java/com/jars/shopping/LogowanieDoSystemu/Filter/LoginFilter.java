package com.jars.shopping.LogowanieDoSystemu.Filter;

import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    @Inject
    SessionData sessionData;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Filter !!!!");
        filterChain.doFilter(servletRequest, servletResponse);

        if (!sessionData.isLogged()) {
            //przekierowanie na logowanie
          //  HttpServletRequest)servletResponse sendRedirect

        }
    }

    @Override
    public void destroy() {

    }
}
