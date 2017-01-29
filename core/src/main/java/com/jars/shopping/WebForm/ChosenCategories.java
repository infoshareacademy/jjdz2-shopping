package com.jars.shopping.WebForm;

import java.util.ArrayList;
import java.util.List;

public class ChosenCategories {



    private List<String> allegro = new ArrayList<String>();
    private List<String> ebay = new ArrayList<String>();

    ChosenCategories (List<String> allegro, List<String> ebay) {
        this.allegro = allegro;
        this.ebay = ebay;
    }

    public List<String> getAllegro() {
        return allegro;
    }

    public List<String> getEbay() {
        return ebay;
    }

}
