package com.jars.shopping.ProductList;


import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/favourites")
public class FavouritesListServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(FavouritesListServlet.class);
    private static final Marker FAVSERVLET = MarkerFactory.getMarker("FAVOURITES_SERVLET");

    @EJB
    ProductListDao prodLDao;

    @Inject
    SessionData sessionData;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userName = sessionData.getName();
        if((userName==null)){
            userName = "default_user";
        }

        LOGGER.info(FAVSERVLET, "Pobierz wybrane urle do usuniecia");
        String[] listOfUrls = req.getParameterValues("listofurls");
        if(listOfUrls!=null) {
            for (String lUrls : listOfUrls) {
                LOGGER.info(FAVSERVLET, "Url do usuniecia " + lUrls);
                prodLDao.delProductByUrl(lUrls, userName);
            }
        }
        LOGGER.info(FAVSERVLET, "Pobierz elementy z bazy danych");

        List<Products> fullListFromDB = prodLDao.getProductsbyUser(userName);
        req.setAttribute("fullListFromDB", fullListFromDB);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/favourites.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userName = sessionData.getName();
        if((userName==null)){
            userName = "default_user";
        }

        LOGGER.info(FAVSERVLET, "Pobierz elementy z bazy danych");

        List<Products> fullListFromDB = prodLDao.getProductsbyUser(userName);
        req.setAttribute("fullListFromDB", fullListFromDB);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/favourites.jsp");
        dispatcher.forward(req, resp);
    }

}
