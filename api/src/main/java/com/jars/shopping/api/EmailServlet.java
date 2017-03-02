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

   @EJB
   private EmailSender sender;

   @EJB
   EmailTimer emailTimer;


    private String email;
    private String topic;
    int everyXhours;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do get w servlecie");
        sender.send("kkubicki2@gmail.com", "Test mail", "To jest testowy mail z servera");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        email = req.getParameter("email");
        topic = req.getParameter("topic");
        everyXhours = (Integer.valueOf(req.getParameter("every")));

        System.out.println(email);
        System.out.println(topic);
        System.out.println(everyXhours);

        emailTimer.start(everyXhours, 0, email);
        System.out.println("Email Timer should start");
    }
}
