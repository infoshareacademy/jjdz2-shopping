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

    public void getAllegroLinks(List<OfferedCategories> answersList) {

        for (OfferedCategories offeredCategories : answersList) {

            allegro.addAll(offeredCategories.getPl());
            eBayCatNames.addAll(offeredCategories.getEn());
        }

        //System.out.println(answersList.size());




    }


    private void printAllegroStrings() {
        for (String s : allegro) System.out.println(s);
    }

    private void printEbayStrins() {
        for (String s : eBayCatNames) System.out.println(s);
    }

    private void printAllCategories() {
        for (Category s : allAllegroCategories) System.out.println(s.getCatName());

    }
}
