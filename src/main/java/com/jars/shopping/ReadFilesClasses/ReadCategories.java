package com.jars.shopping.ReadFilesClasses;

import com.jars.shopping.POJOs.Category;

import java.util.ArrayList;
import java.util.List;

public class ReadCategories {


    private List<Category> categories = new ArrayList<Category>();

    public List<Category> getMatchinCategories(String catName) {
        /** JS - 25 - return the list of categories that contain a specific string @param catName*/

        List<Category> catNames = new ArrayList<Category>();

        for (int i = 0; i < categories.size(); i++) {
            int counter = 0;
            if (categories.get(i).getCatName().contains(catName)) {
                catNames.add(categories.get(i));
                counter++;
                System.out.println("Found " + counter + " matching categories, that contains " + catName + "\n" +
                        "Category " + categories.get(i) + " matches the seaarch criteria");
            }
        }
        return catNames;
    }

    public void printNMatchingCategories(int n, String catName) {
        /** Prints out n matching categories */
        List<Category> matchingCategories = new ArrayList<Category>();
        matchingCategories = getMatchinCategories(catName);
        for (int i=0; i<n; i++) System.out.println(matchingCategories.get(i));
    }








    /**
     * Getter & Setter
     */
    public List<Category> getCategories() {
        //TODO: - JS-24 - Return ALL categories from XML file
        return categories;
    }

    public void setCategories(List<Category> categories) {
        // Probably won't be needed, coulbe be needed if we will have to add new categories besides the ones that were
        // received from the Allegro XML.
        this.categories = categories;
    }
}






