package com.jars.shopping.WebForm;

import com.jars.shopping.UserInteractions.AskQuestions;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class QuestionsReferenceServlet extends HttpServlet{

//    @EJB
//    QuestionsReference questionsReference;

    @EJB
    AskQuestions askQuestions;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

       // String question = questionsReference.referQuestion();
        // req.setAttribute("hello", question);

        askQuestions.startAsking();


        RequestDispatcher dispatcher = req.getRequestDispatcher("/webForm.jsp");
        dispatcher.forward(req, resp);
    }

}
