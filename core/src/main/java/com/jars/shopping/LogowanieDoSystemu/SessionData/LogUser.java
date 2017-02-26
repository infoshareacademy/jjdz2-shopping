package com.jars.shopping.LogowanieDoSystemu.SessionData;

import com.jars.shopping.REST.UserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;


@WebServlet(urlPatterns = "/logUser")
public class LogUser extends HttpServlet {


    public static final Logger LOGGER = LoggerFactory.getLogger(LogUser.class);
    public static final Marker USERLOGIN = MarkerFactory.getMarker("USER_LOGIN");
    @Inject
    SessionData sessionData;

    @Inject
    UserDao userDao;

    @Inject
    Event<UserData> userDataEvent;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LOGGER.info(USERLOGIN, " \n\nODPALONO DO POST w LOG USER  \n\n");
        LOGGER.info(USERLOGIN, " Attempting to log the user in: " + req.getParameter("username"));

        if (userDao.passwordOK(req.getParameter("username"), req.getParameter("password"))) {
            LOGGER.info(USERLOGIN, " Password seems to be fine for " + req.getParameter("username"));
            sessionData.setName(req.getParameter("username"));
            sessionData.setLogged(true);
            sessionData.setLoggedFrom(req.getRequestURI());

            // fire event
            /*LocalDate date = LocalDate.now();
            ZoneId zoneId = ZoneId.systemDefault();
            long epoch = System.currentTimeMillis();//date.atStartOfDay(zoneId).toEpochSecond();
            */
            long epoch = Instant.now().getEpochSecond();
            userDataEvent.fire(new UserData(req.getParameter("username"), epoch));


            if (userDao.getSingleUser(req.getParameter("username")).isAdmin()) {
                LOGGER.info(USERLOGIN, " User seems to be an ADMIN, redirecting to Admin Panel");
                resp.sendRedirect("/adminPanel");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("/inAppUserLoggedInCallback.jsp");
                dispatcher.forward(req, resp);
            }

        } else {
            LOGGER.warn(USERLOGIN, " Login failed for user : " + req.getParameter("username"));
            sessionData.clearUserInfo();
            resp.sendRedirect("/login");
        }
    }
}
