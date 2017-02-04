package com.jars.shopping.REST;

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
import java.net.URISyntaxException;
import java.time.LocalDate;

/**
 * Created by marcinpankowski on 04.02.17.
 */
@WebServlet(urlPatterns = "/report")
public class ReportServlet extends HttpServlet{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReportServlet.class);
    private static final Marker REPORTSERVLET = MarkerFactory.getMarker("REPORT_SERVLET");

    @Inject
    ClientForAPI clientForAPI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        LOGGER.info(REPORTSERVLET,"Pobierz dane do raportu o userach");

        LocalDate fromDate = LocalDate.now();
        LocalDate toDate = LocalDate.now();


        try {
            clientForAPI.getDataFromAPI(fromDate,toDate);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        RequestDispatcher dispatcher = req.getRequestDispatcher("/report.jsp");
        dispatcher.forward(req, resp);
    }

}
