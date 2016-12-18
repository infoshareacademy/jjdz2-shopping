package com.jars.shopping.AdminTools;


import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
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
public class AdminPanel extends HttpServlet {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminPanel.class);
    public static final Marker ADMINPANEL = MarkerFactory.getMarker("ADMIN_PANEL ");

    @Inject
    UserDao userDao;

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(ADMINPANEL, " doGet in Admin Panel");
        List<User> userList = userDao.getAllUsers();
        req.setAttribute("userlist", userList);
        req.setAttribute("login", sessionData.getName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/adminPanel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info(ADMINPANEL, " \n\n\ndoPost in Admin Panel\n\n\n");
        LOGGER.info(ADMINPANEL, " \n\n\n " + req.getParameter("action") + "\n\n\n");

        if ("addPrivileges".equals(req.getParameter("action"))) {
            String[] newAdmins = req.getParameterValues("newAdmins");
            userDao.makeAdmins(newAdmins);
            LOGGER.info(ADMINPANEL, "Made " + newAdmins.length + " new Admins....");
            doGet(req, resp);
        }
        if ("removePrivileges".equals(req.getParameter("action"))) {
            String[] newAdmins = req.getParameterValues("newAdmins");
            userDao.removeAdmins(newAdmins);
            LOGGER.info(ADMINPANEL, "Removed privileges for " + newAdmins.length + " ex-admins....");
            doGet(req, resp);
        }
        if ("logout".equals(req.getParameter("logout"))) {
            sessionData.clearUserInfo();
            resp.sendRedirect("/login");
        }
    }
}

