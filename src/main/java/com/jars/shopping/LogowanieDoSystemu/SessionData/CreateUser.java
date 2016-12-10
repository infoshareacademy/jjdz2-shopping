package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.LogowanieDoSystemu.Login;
import com.jars.shopping.Users.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateUser.class);
    private static final Marker CREATEUSER = MarkerFactory.getMarker("CREATE_USER");

    @Inject
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        LOGGER.info(CREATEUSER," Previously typed login "+ username);
        String password = req.getParameter("password");
        LOGGER.info(CREATEUSER," Previously typed password "+ password);
        req.setAttribute("username", username);
        req.setAttribute("password", password);
        //req.setAttribute("pass1234", password);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/createNewUser.jsp");
        LOGGER.info(CREATEUSER," Display login screen");
        dispatcher.forward(req, resp);
    }
}