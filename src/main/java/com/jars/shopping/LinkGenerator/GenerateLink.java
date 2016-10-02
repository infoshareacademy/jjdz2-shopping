package com.jars.shopping.LinkGenerator;


import java.util.ArrayList;
import java.util.List;

public class GenerateLink {
    private List<String> linkList = new ArrayList<String>();


    public List<String> GenerateLinkAllegro(List<Integer> catIds){
        linkList.clear();
        if(!catIds.isEmpty()){
            for(int idNumber: catIds){
                linkList.add("http://allegro.pl/some-cat-" + Integer.toString(idNumber));
            }
        }
        return linkList;
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
