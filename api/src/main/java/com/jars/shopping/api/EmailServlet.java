package com.jars.shopping.api;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/EmailServlet")

public class EmailServlet extends HttpServlet {

//    @EJB
//    private EmailSender sender;
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("\n\n\n\n\n\n\n\nDo Get w servlecie!!!!\n\n\n\n\n\n\n");
//      //  sender.send("kkubicki2@gmail.com", "Test email", "Message body tra la la la la la");
//    }
}
