package com.jars.shopping.ProductList;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJB;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info(FAVSERVLET, "Pobierz wybrane urle do usuniecia");
        String[] listOfUrls = req.getParameterValues("listofurls");
        if(listOfUrls!=null) {
            for (String lUrls : listOfUrls) {
                LOGGER.info(FAVSERVLET, "Url do usuniecia " + lUrls);
                prodLDao.delProductByUrl(lUrls);
            }
        }
        LOGGER.info(FAVSERVLET, "Pobierz elementy z bazy danych");

        List<Products> fullListFromDB = prodLDao.getProducts();
        req.setAttribute("fullListFromDB", fullListFromDB);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/favourites.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info(FAVSERVLET, "Pobierz elementy z bazy danych");

        List<Products> fullListFromDB = prodLDao.getProducts();
        req.setAttribute("fullListFromDB", fullListFromDB);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/favourites.jsp");
        dispatcher.forward(req, resp);
    }

}
