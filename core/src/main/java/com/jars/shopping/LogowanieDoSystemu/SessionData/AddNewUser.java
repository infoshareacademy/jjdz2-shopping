package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/AddNewUser")
public class AddNewUser extends HttpServlet {

    @Inject
    UserDao userDao;

    @Inject
    SessionData sessionData;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String cameFrom = "InAppCreated";
        boolean isAdmin = false;

        userDao.saveUserInDataBase(new User(username, DigestUtils.sha1Hex(password), cameFrom, isAdmin));

        sessionData.clearUserInfo();
        resp.sendRedirect("/login");
    }
}
