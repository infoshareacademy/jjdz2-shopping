package com.jars.shopping.ProductList;


import javax.ejb.EJB;
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
            //ebayauction
            //allegroauction
    @EJB
    ProductsEbayService serviceEbay;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String word = req.getParameter("word");
        List<Word> translatedWordsAllegro = serviceAllegro.translate(word);

        String word = req.getParameter("word");
        List<Word> translatedWordsEbay = serviceEbay.translate(word);

        req.setAttribute("translatedWords",translatedWords);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/products.jsp");
        dispatcher.forward(req, resp);
    }


}
