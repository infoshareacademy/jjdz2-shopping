package com.jars.shopping.UserInteractions;


import com.jars.shopping.LinkGenerator.GenerateLink;
import com.jars.shopping.POJOs.Category;
import com.jars.shopping.ReadFilesClasses.ReadCategories;

import java.util.*;

public class Results {

    Set<String> allegro = new TreeSet<>();
    List<String> eBayCatNames = new ArrayList<>();
    List<Category> allAllegroCategories = new ReadCategories().getCategories();
    GenerateLink generateLink = new GenerateLink();
    ReadCategories rc = new ReadCategories();

    public void getAllegroLinks(List<String> pl, List<String> en) {

        //System.out.println("Size pl : " + pl.size());
        //System.out.println("Size en : " + en.size());

        List<Integer> idList = new ArrayList<>();
        for (String s : pl) {
            List<Category> catList = rc.getMatchinCategories(s);
            for (Category c : catList) {
                idList.add(c.getCatId());
            }
        }

        allegro = generateLink.GenerateLinkAllegro(idList);
        //System.out.println("Size allegro : "+ allegro.size());

        eBayCatNames = generateLink.GenerateLinkEbay(en);
        //System.out.println("Size ebay : "+ eBayCatNames.size());
    }

    public void printAllegroLinks() {
            int i=0;

        for (String idAllegro : allegro) {
            i++;
            System.out.println("Link  allegro numer " + (i) + " " + idAllegro);
        }
    }

    public void printEbayLinks() {
        for (int i = 0; i < eBayCatNames.size(); i++) {
            System.out.println("Link ebay numer " + (i + 1) + " " + eBayCatNames.get(i));
        }

    }
}
