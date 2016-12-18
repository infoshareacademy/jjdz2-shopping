package com.jars.shopping.WebForm;

import com.jars.shopping.Statistics.NewStatisticUpdateEvent;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mail.internet.ContentType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/searchProducts")
public class SearchProductServlet extends HttpServlet{

    @Inject
    Event<NewStatisticUpdateEvent> event;

    @Inject
    Event<ChosenCategories> chosenCategoriesEvent;

    private List<String> allegro = new ArrayList<String>();
    private List<String> ebay = new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchProducts.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer i = Integer.parseInt(req.getParameter("size"));

        for (Integer j=0; j<i; j++ ) {
            event.fire(new NewStatisticUpdateEvent("user",req.getParameter("question-"+j.toString()),req.getParameter("radios-"+j.toString())));
            //allegro.add(req.getParameter(""))
        }


        resp.setContentType("application/json; charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchProducts.jsp");
        dispatcher.forward(req, resp);
    }
}
