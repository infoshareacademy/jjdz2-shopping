package com.jars.shopping.AdminTools;


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
import java.util.List;

@WebServlet(urlPatterns = "/adminPanel")
public class AdminPanel extends HttpServlet{

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminPanel.class);
    public static final Marker ADMINPANEL = MarkerFactory.getMarker("ADMIN_PANEL ");

    @Inject
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(ADMINPANEL, " doGet in Admin Panel");

        List<User> userList = userDao.getAllUsers();

        req.setAttribute("userlist", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminPanel.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(ADMINPANEL, " \n\n\ndoPost in Admin Panel\n\n\n");

    }
}
