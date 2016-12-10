package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.Users.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/logUser")
public class LogUser extends HttpServlet {

    @Inject
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<String> usersList = userDao.getUsers();
        if (usersList.contains(req.getParameter("username")));
        {
            List<User> usersFullList = userDao.getAllUsers();
            for (User u: usersFullList
                 ) {
                System.out.println(u.toString());
            }
        }



    }
}
