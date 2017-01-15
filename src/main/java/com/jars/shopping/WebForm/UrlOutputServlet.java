package com.jars.shopping.WebForm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/UrlOutputServlet")
public class UrlOutputServlet extends HttpServlet {

    @Inject
    ProperProducts properProducts;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListServlet.class);
    private static final Marker PARAMETERS = MarkerFactory.getMarker("PARAMETERS");
    private Map<String, String> productListeBay;
    private Map<String, String> productListallegro;

    @PostConstruct
    public void initialize() {
        productListallegro= properProducts.getProductListallegro();
        productListeBay= properProducts.getProductListeBay();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String productName = req.getParameter("productName");
        String id = req.getParameter("serviceId");
        String urlForOutput = "There is no link for this product";

        if (id.equals("allegro")) {
            for (Map.Entry<String, String> s : productListallegro.entrySet()) {
                if (s.getValue().equals(productName)) {
                    urlForOutput = s.getKey();
                }
            }

        }
        else {
            for (Map.Entry<String, String> s : productListeBay.entrySet()) {
                if (s.getValue().equals(productName)) {
                    urlForOutput = s.getKey();
                }
            }
        }

        LOGGER.info(urlForOutput);
        resp.getWriter().write(urlForOutput);
    }

}
