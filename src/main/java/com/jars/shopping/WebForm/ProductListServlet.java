package com.jars.shopping.WebForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productList")
public class ProductListServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListServlet.class);
    private static final Marker PARAMETERS = MarkerFactory.getMarker("PARAMETERS");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String term = req.getParameter("term");
        String id = req.getParameter("serviceId");
        LOGGER.info(PARAMETERS, term + " " + id);
        resp.setContentType("application/json; charset=UTF-8");
        resp.getWriter().write("[{\"id\": \"Siema\", \"label\": \"siema_label\", \"value\": \"siema_val\"}," +
                "{\"id\": \"ola\", \"label\": \"ola_label\", \"value\": \"ola_value\"}]");


    }
}
