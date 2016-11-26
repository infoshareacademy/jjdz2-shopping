package com.jars.shopping.UserInteractions;


import com.jars.shopping.LinkGenerator.GenerateLink;
import com.jars.shopping.POJOs.Category;
import com.jars.shopping.ReadFilesClasses.ReadCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.*;

public class Results {

    Set<String> allegro = new LinkedHashSet<>();
    List<String> eBayCatNames = new ArrayList<>();
    List<Category> allAllegroCategories = new ReadCategories().getCategories();
    GenerateLink generateLink = new GenerateLink();
    ReadCategories rc = new ReadCategories();
    private static final Logger LOGGER = LoggerFactory.getLogger(Results.class);
    private static final Marker RESULTS = MarkerFactory.getMarker("RESULTS");

    public void getAllegroLinks(List<String> pl, List<String> en) {
        LOGGER.info(RESULTS,"Prepare Allegro links");
        //System.out.println("Size pl : " + pl.size());
        //System.out.println("Size en : " + en.size());

        List<Integer> idList = new ArrayList<>();
        for (String s : pl) {
            List<Category> catList = rc.getMatchinCategories(s);
            for (Category c : catList) {
                idList.add(c.getCatId());
            }
        }

        LOGGER.info(RESULTS,"Generate Allegro links");
        allegro = generateLink.GenerateLinkAllegro(idList);
        //System.out.println("Size allegro : "+ allegro.size());

        LOGGER.info(RESULTS,"Generate Ebay links");
        eBayCatNames = generateLink.GenerateLinkEbay(en);
        //System.out.println("Size ebay : "+ eBayCatNames.size());
    }

    public void printAllegroLinks() {
        LOGGER.info(RESULTS,"Print Allegro links");
        int i=0;

        for (String idAllegro : allegro) {
            i++;
            System.out.println("Link  allegro numer " + (i) + " " + idAllegro);
        }
    }

    public void printEbayLinks() {
        LOGGER.info(RESULTS,"Print Ebay links");
        for (int i = 0; i < eBayCatNames.size(); i++) {
            System.out.println("Link ebay numer " + (i + 1) + " " + eBayCatNames.get(i));
        }

    }
}
