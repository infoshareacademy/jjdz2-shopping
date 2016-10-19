package com.jars.shopping.LinkGenerator;


import java.util.ArrayList;
import java.util.List;

public class GenerateLink {
    private List<String> linkList = new ArrayList<String>();
    private List<String> linkListAllegro = new ArrayList<String>();


    public List<String> GenerateLinkAllegro(List<Integer> catIds){
        linkListAllegro.clear();
        if(!catIds.isEmpty()){
            for(int idNumber: catIds){
                linkListAllegro.add("http://allegro.pl/some-cat-" + Integer.toString(idNumber));
            }
        }
        return linkListAllegro;
    }

    public List<String> GenerateLinkEbay(List<String> catNames){
        linkList.clear();
        if(!catNames.isEmpty()){
            for(String catName: catNames){
                catName = catName.replaceAll("\\s+","-");
                linkList.add("http://www.ebay.com/sch/" + catName);
            }
        }
        return linkList;
    }

}
