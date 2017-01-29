package com.jars.shopping.WebForm;

import com.jars.shopping.LogowanieDoSystemu.SessionData.SessionData;
import com.jars.shopping.POJOs.models.OptionsOfAnswers;
import com.jars.shopping.POJOs.models.Question;
import com.jars.shopping.POJOs.models.Questionary;
import com.jars.shopping.Statistics.NewStatisticUpdateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.mail.internet.ContentType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/searchProducts")
public class SearchProductServlet extends HttpServlet{

    @EJB
    Questionary questionary;

    @Inject
    Event<NewStatisticUpdateEvent> event;

    @Inject
    Event<ChosenCategories> chosenCategoriesEvent;

    @Inject
    SessionData sessionData;

    private List<String> allegro = new ArrayList<String>();
    private List<String> ebay = new ArrayList<String>();

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchProductServlet.class);
    private static final Marker PARAMETERS = MarkerFactory.getMarker("PARAMETERS");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchProducts.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer size = Integer.parseInt(req.getParameter("size"));
        List <Question> questions = questionary.getQuestions();

        if (size!=null) {
            for (Integer j = 0; j < size; j++) {

                for (OptionsOfAnswers opt : questions.get(j).getOptions()
                        ) {
                    if (opt.getLabel().equals(req.getParameter("radios-" + j.toString()))) {
                        for (String c : opt.getCategories().getPl()
                                ) {
                            allegro.add(c);
                        }
                        for (String c : opt.getCategories().getEn()
                                ) {
                            ebay.add(c);
                        }
                    }

                }

                chosenCategoriesEvent.fire(new ChosenCategories(allegro, ebay));
            }
        }

        resp.setContentType("application/json; charset=UTF-8");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/searchProducts.jsp");
        dispatcher.forward(req, resp);
    }
}
