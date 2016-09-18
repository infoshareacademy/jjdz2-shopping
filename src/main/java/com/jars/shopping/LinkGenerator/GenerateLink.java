package com.jars.shopping.LinkGenerator;


public class GenerateLink {



    public List<String> AllegroLinksGenerator(List<int> catIds){
        List<String> linkList = new ArrayList<String>();

        if(!catIds.isEmpty()){
            for(String idNumber: catNames){
                linkList.add("http://allegro.pl/some-cat-" + Integer.toString(idNumber));
            }
        }
    return linkList;
    }

}
