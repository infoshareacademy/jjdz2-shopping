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

@WebServlet(urlPatterns = "/products")
public class ProductsListServlet extends HttpServlet{
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsListServlet.class);
    private static final Marker PRODUCTSSERVLET = MarkerFactory.getMarker("PRODUCTS_SERVLET");


    @EJB
    ProductsEbayService serviceEbay;

    @EJB
    ProductsAllegroService serviceAllegro;

    @EJB
    ProductListDao prodLDao;

    @Inject
    SessionData sessionData;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info(PRODUCTSSERVLET,"Pobierz kategorię dla Ebay");
        String ebayauction = req.getParameter("ebayauction");

        LOGGER.info(PRODUCTSSERVLET,"Pobierz kategorię dla Allegro");
        String allegroauction = req.getParameter("allegroauction");

        LOGGER.info(PRODUCTSSERVLET,"Pobierz listę wybranych produktów dla Ebay");
        String[] listofebayprod = req.getParameterValues("listofebayprod[]");

        LOGGER.info(PRODUCTSSERVLET,"Pobierz listę wybranych produktów dla Allegro");
        String[] listofallegroprod = req.getParameterValues("listofallegroprod[]");

        String userName = sessionData.getName();
        if((userName==null)){
            userName = "default_user";
        }

        if(listofebayprod!=null) {
            LOGGER.info(PRODUCTSSERVLET,"Przkaż wybrane produkty z Ebay do bazy danych");
            prodLDao.addListProducts(listofebayprod, userName);

            LOGGER.info(PRODUCTSSERVLET,"Wyczyść listę wszystkich produktów z Ebay");
            ebayauction="";
        }
        if(listofallegroprod!=null) {
            LOGGER.info(PRODUCTSSERVLET,"Przkaż wybrane produkty z Allegro do bazy danych");
            prodLDao.addListProducts(listofallegroprod, userName);


            LOGGER.info(PRODUCTSSERVLET,"Wyczyść listę wszystkich produktów z Allegro");
            allegroauction="";
        }

        if(ebayauction!=null){
            LOGGER.info(PRODUCTSSERVLET,"Jeżeli istnieje kategoria dla Ebay - pobierz listę produktów");

            List<Products> translatedWordsEbay = serviceEbay.translate(ebayauction);
            req.setAttribute("translatedWordsEbay",translatedWordsEbay);
        }else if(allegroauction!=null){
            LOGGER.info(PRODUCTSSERVLET,"Jeżeli istnieje kategoria dla Allegro - pobierz listę produktów");

            List<Products> translatedWordsAllegro = serviceAllegro.translate(allegroauction);
            req.setAttribute("translatedWordsAllegro",translatedWordsAllegro);
        }

        LOGGER.info(PRODUCTSSERVLET,"Pobierz listę elementów z bazy dancych");
        List<Products> fullListFromDB = prodLDao.getProducts();
        req.setAttribute("fullListFromDB",fullListFromDB);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req, resp);
    }

}
