package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by keehoo on 27.11.16.
 */

@WebServlet (urlPatterns = "/createUser")
public class CreateUser extends HttpServlet {

    @Inject
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("Stworzono uzytkownika "+ username);
        userDao.saveUserInDataBase(new User(username, password));


    }
}
