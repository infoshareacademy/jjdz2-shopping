package com.jars.shopping.ProductList;


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
public class ProductsServlet extends HttpServlet{
    @EJB
    ProductsEbayService serviceEbay;

    @EJB
    ProductsAllegroService serviceAllegro;

    @EJB
    ProductListDao prodLDao;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       // String word = req.getParameter("word");
       // List<Word> translatedWordsAllegro = serviceAllegro.translate(word);

        //set category - ebay
        String ebayauction = req.getParameter("ebayauction");

        //set category - allegro
        String allegroauction = req.getParameter("allegroauction");

        //set list of Ebay products
        String[] listofebayprod = req.getParameterValues("listofebayprod");

        //set list of Allegro products
        String[] listofallegroprod = req.getParameterValues("listofallegroprod");
/////////////
        if(listofebayprod!=null) {
            //pass these values to database
            prodLDao.addListProducts(listofebayprod);
            //del
            /*
            for (String st : listofebayprod) {
                System.out.println(">> " +
                        st);
            }*/
            //del

            //clear list of elements if prev step was to check some elements
            ebayauction="";
        }
        if(listofallegroprod!=null) {
            //pass these values to database
            prodLDao.addListProducts(listofebayprod);
            /*
            for (String st : listofallegroprod) {
                System.out.println(">> " +
                        st);
            }*/
            //clear list of elements if prev step was to check some elements
            allegroauction="";
        }
//////////////
        System.out.println(">> >>");
//////////////

        if(ebayauction!=null){

            System.out.println("OK ebay");
            //set Ebay category
            List<Products> translatedWordsEbay = serviceEbay.translate(ebayauction);
            req.setAttribute("translatedWordsEbay",translatedWordsEbay);

        }else if(allegroauction!=null){

            System.out.println("NO OK ebay");
            //set Allegro category
            List<Products> translatedWordsAllegro = serviceAllegro.translate(allegroauction);
            req.setAttribute("translatedWordsAllegro",translatedWordsAllegro);

        }

            List<Products> fullListFromDB = prodLDao.getProducts();
            req.setAttribute("fullListFromDB",fullListFromDB);


////////////////
        //set Ebay category
        //List<Products> translatedWordsEbay = serviceEbay.translate(ebayauction);
        //req.setAttribute("translatedWordsEbay",translatedWordsEbay);

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
