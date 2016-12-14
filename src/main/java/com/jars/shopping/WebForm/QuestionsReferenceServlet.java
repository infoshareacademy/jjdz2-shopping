package com.jars.shopping.WebForm;

import com.jars.shopping.POJOs.models.Question;
import com.jars.shopping.POJOs.models.Questionary;
import com.jars.shopping.Statistics.NewStatisticUpdateEvent;
import com.jars.shopping.Statistics.StatisticsLogger;
import com.jars.shopping.UserInteractions.AskQuestions;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/webForm")
public class QuestionsReferenceServlet extends HttpServlet{

    @EJB
    Questionary questionary;

    @Inject
    Event<NewStatisticUpdateEvent> event;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        List <Question> questions = questionary.getQuestions();


        req.setAttribute("questionList", questions);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/webForm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
