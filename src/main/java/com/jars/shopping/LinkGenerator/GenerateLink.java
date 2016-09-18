package com.jars.shopping.LinkGenerator;


public class GenerateLink {
    private List<String> linkList = new ArrayList<String>();


    public List<String> AllegroLinksGenerator(List<int> catIds){
        if(!catIds.isEmpty()){
            for(String idNumber: catNames){
                linkList.add("http://allegro.pl/some-cat-" + Integer.toString(idNumber));
            }
        }
        return linkList;
    }

    public List<String> EbayLinksGenerator(List<String> catNames){
        if(!catNames.isEmpty()){
            for(String catName: catNames){
                catName = catName.replaceAll("\\s+","-")
                linkList.add("http://www.ebay.com/sch/" + catName);
            }
        }
        return linkList;
    }

}
