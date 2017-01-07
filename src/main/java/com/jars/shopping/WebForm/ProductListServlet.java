package com.jars.shopping.WebForm;

import com.google.gson.Gson;
import com.jars.shopping.ProductList.ProductListEvent;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.enterprise.event.Observes;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;


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



        Map<String, String> catList = new HashMap<>();
        Map<String, String> dropList = new HashMap<>();

        catList.put("URL1", "stro");
        catList.put("URL2", "stra");
        catList.put("URL3","stron");
        catList.put("URL4","strong");

        for (Map.Entry<String, String> s:catList.entrySet()) {
            if (s.getValue().startsWith(term)){
                dropList.put(s.getKey(), s.getValue());
            }
        }

        String json = new Gson().toJson(dropList);

        resp.getWriter().write(json);

    }
}
