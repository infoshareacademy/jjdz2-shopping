package com.jars.shopping;

import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by keehoo on 11.12.16.
 */

@WebServlet (urlPatterns = "/")
public class MainPage extends HttpServlet {

    @Inject
    SessionData sessionData;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        if(!sessionData.isLogged()) {
            resp.sendRedirect("/login");
        }

    }
}
