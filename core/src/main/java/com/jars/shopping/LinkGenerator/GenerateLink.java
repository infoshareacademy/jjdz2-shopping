package com.jars.shopping.LinkGenerator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.spi.LocaleServiceProvider;

public class GenerateLink {
    private List<String> linkList = new ArrayList<>();
    private Set<String> linkListAllegro = new TreeSet<>();
    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateLink.class);
    private static final Marker GENERATE_LINK = MarkerFactory.getMarker("GENERATE LINK");

    public Set<String> GenerateLinkAllegro(List<Integer> catIds){
        LOGGER.info(GENERATE_LINK,"Generate links for Allegro");
        linkListAllegro.clear();
        if(!catIds.isEmpty()){
            for(int idNumber: catIds){
                linkListAllegro.add("http://allegro.pl/some-cat-" + Integer.toString(idNumber));
            }
        }
        return linkListAllegro;
    }

    public List<String> GenerateLinkEbay(List<String> catNames){
        LOGGER.info(GENERATE_LINK,"Generate links for Ebay");
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
