package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.LogowanieDoSystemu.FacebookLogin;
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


@WebServlet(urlPatterns = "/logUser")
public class LogUser extends HttpServlet {


    public static final Logger LOGGER = LoggerFactory.getLogger(LogUser.class);
    public static final Marker USERLOGIN = MarkerFactory.getMarker("USER_LOGIN");
    @Inject
    SessionData sessionData;

    @Inject
    UserDao userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(USERLOGIN, " \n\nODPALONO DO POST w LOG USER  \n\n");
        LOGGER.info(USERLOGIN, " Attempting to log the user in: " + req.getParameter("username"));

        if (userDao.passwordOK(req.getParameter("username"), req.getParameter("password"))) {

            sessionData.setName(req.getParameter("username"));
            sessionData.setLogged(true);
            sessionData.setLoggedFrom("???"); //TODO: dodac informacje skad uzytkownik sie zalogowal


            //req.setAttribute("translatedWords",translatedWords);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/inAppUserLoggedInCallback.jsp");
            dispatcher.forward(req, resp);
        } else {
            LOGGER.warn(USERLOGIN, " Login failed for user : " + req.getParameter("username"));
            sessionData.clearUserInfo();
            resp.sendRedirect("/login");
        }
    }
}
