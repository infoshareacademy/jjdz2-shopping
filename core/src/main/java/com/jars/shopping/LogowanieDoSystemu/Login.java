package com.jars.shopping.LogowanieDoSystemu;


import com.jars.shopping.LogowanieDoSystemu.SessionData.UserDao;
import com.jars.shopping.Users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);
    private static final Marker LOGIN = MarkerFactory.getMarker("LOGIN");

    @Inject
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String welcome = "Welcome to the login page";
        req.setAttribute("welcome", welcome);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        LOGGER.info(LOGIN," Display login screen");
        dispatcher.forward(req, resp);
    }
}
