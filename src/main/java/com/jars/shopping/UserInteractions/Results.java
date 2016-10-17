package com.jars.shopping.UserInteractions;


import com.jars.shopping.LinkGenerator.GenerateLink;
import com.jars.shopping.POJOs.Category;
import com.jars.shopping.POJOs.models.OfferedCategories;
import com.jars.shopping.ReadFilesClasses.ReadCategories;

import java.util.ArrayList;
import java.util.List;

public class Results {

    List<String> allegro = new ArrayList<>();
    List<String> eBayCatNames = new ArrayList<>();
    List<Category> allAllegroCategories = new ReadCategories().getCategories();
    GenerateLink generateLink = new GenerateLink();
    ReadCategories rc = new ReadCategories();

    public void getAllegroLinks(List<String> pl, List<String> en) {

        List<Integer> idList = new ArrayList<>();
        for (String s : pl) {
            List<Category> catList = rc.getMatchinCategories(s);
            for (Category c : catList) {
                idList.add(c.getCatId());
            }
        }

        allegro = generateLink.GenerateLinkAllegro(idList);
        eBayCatNames = generateLink.GenerateLinkEbay(en);
    }

    public void printAllegroLinks() {
        for (int i = 0; i < allegro.size(); i++) {
            System.out.println("Link  allegro numer " + (i + 1) + " " + allegro.get(i));
        }
    }

    public void printEbayLinks() {
        for (int i = 0; i < eBayCatNames.size(); i++) {
            System.out.println("Link ebay numer " + (i + 1) + " " + eBayCatNames.get(i));
        }

    }
}
