package com.jars.shopping.UserInteractions;

import com.jars.shopping.POJOs.models.OfferedCategories;
import com.jars.shopping.POJOs.models.OptionsOfAnswers;
import com.jars.shopping.POJOs.models.Question;
import com.jars.shopping.POJOs.models.Questionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import java.util.*;

@Stateless
public class AskQuestions {

    List<Question> questionList;
    List<OptionsOfAnswers> optionsList;
    List<OfferedCategories> answersList;
    Scanner scanner = new Scanner(System.in);
    private static final Logger LOGGER = LoggerFactory.getLogger(AskQuestions.class);
    private static final Marker ASK_QUESTIONS = MarkerFactory.getMarker("ASK QUESTIONS");

    public void startAsking() {
        LOGGER.info(ASK_QUESTIONS,"Start asking questions!");
        Questionary questionary = new Questionary();

        LOGGER.info(ASK_QUESTIONS,"Prepare question list");
        questionList = new ArrayList<>();
        LOGGER.info(ASK_QUESTIONS,"Prepare options list");
        optionsList = new ArrayList<>();
        LOGGER.info(ASK_QUESTIONS,"Prepare answers list");
        answersList = new ArrayList<>();
        questionList = questionary.getQuestions();

        LOGGER.info(ASK_QUESTIONS,"Print possible options");
        for (Question q : questionList) {

            System.out.println(q.getTitle());
            System.out.println("Opcje: ");
            List<OptionsOfAnswers> options = q.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println("Opcja " + (i + 1) + "   ---   " + options.get(i).getLabel());

            }

            int selecion = scanner.nextInt();
            while (selecion > options.size() || selecion < 1) {
                System.out.println("Prosze wybrac od 1 do 3");
                selecion = scanner.nextInt();
            }

                //System.out.println("Wybrano odpowiedz " + selecion + " , czyli, " + options.get(selecion - 1).toString());
                //System.out.println(options.get(selecion - 1).getCategories().toString());
                answersList.add(options.get(selecion - 1).getCategories());

        }
        printOutResultsOfAnswers();
    }

    private void printOutResultsOfAnswers() {
        LOGGER.info(ASK_QUESTIONS,"Print results");
        System.out.println("************************");
        System.out.println("**** REZULTATY *********");
        System.out.println("************************");

        List<String> en = new ArrayList<>();
        List<String> pl = new ArrayList<>();

        for (OfferedCategories o : answersList) {
            //System.out.println("Lista kategorii EN");

            for (String s : o.getEn()) {
                en.add(s);
            }

            //System.out.println("Lista kategorii PL:");
            for (String s : o.getPl()) {
                pl.add(s);
            }
        }

        System.out.println("Lista kategorii EN:");
        for (String s : en) System.out.println(" -->"+s);

        System.out.println("Lista kategorii PL");
        for (String s : pl) System.out.println(" -->"+s);


        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println("************************");
        System.out.println(" Czy chcesz wygenerowac linki do Allegro i eBay? (Y/N)");
        if (scanner.next().toLowerCase().equals("y")) {
            Results results = new Results();
            results.getAllegroLinks(pl, en);
            results.printAllegroLinks();
            results.printEbayLinks();
            System.exit(0);
        } else System.exit(0);
    }

}

