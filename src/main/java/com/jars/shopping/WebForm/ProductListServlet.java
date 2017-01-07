package com.jars.shopping.WebForm;

import com.google.gson.Gson;
import org.json.simple.JSONArray;
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
import java.util.ArrayList;
import java.util.List;
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

        ArrayList<String> catList = new ArrayList<String>();
        ArrayList<String> dropList = new ArrayList<String>();
//        catList.add("stro");
//        catList.add("stri");
//        catList.add("strn");
//        catList.add("strom");

        for (String s:catList
             ) {
            if (s.startsWith(term)){
                dropList.add(s);
            }
        }

        String json = new Gson().toJson(dropList);

        resp.getWriter().write(json);

    }
}
