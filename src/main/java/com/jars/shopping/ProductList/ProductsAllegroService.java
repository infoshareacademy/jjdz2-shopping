package com.jars.shopping.ProductList;

import com.jars.shopping.ReadFilesClasses.ReadCategories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Stateless
public class ProductsAllegroService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsAllegroService.class);
    private static final Marker PRODALLEGROSERVICE = MarkerFactory.getMarker("PRODUCTS_ALLEGRO_SERVICE");

    @Inject
    @Named("allegroUrl")
    String allegroUrl;

    public List<Products> translate(String input) {
        String catValue = generateValueForAllegro(input);
        List<Products> allWordsAllegro = new ArrayList<>();

        if(!catValue.isEmpty() && !catValue.equals("") && (catValue!=null)){

        LOGGER.info(PRODALLEGROSERVICE,"Parsuj Allegro dla kategorii : " + catValue.toString());
        final String urlString = String.format(allegroUrl, catValue);

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            final Pattern pat = Pattern
            .compile("class=\"offer-title\" href=\".*\">(.*)</a>");

             allWordsAllegro = reader.lines()
                    .map(s -> pat.matcher(s))   // do matching
                    .filter(Matcher::find)      // filter matches
                    .map(m -> m.group(m.groupCount())) // extract word
                    .map(Products::new)
                    .collect(Collectors.toList());

            //System.out.println(Arrays.asList(allWords));

            return allWordsAllegro;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        }else{
            LOGGER.info(PRODALLEGROSERVICE,"Wartość kategorii jest pusta");
            return allWordsAllegro;
        }

    }

    private String generateValueForAllegro(String input) {
        LOGGER.info(PRODALLEGROSERVICE,"Pobierz nazwę kategorii dla Allegro, z nr: " + input.toString());
        String output_id = "";

        if(input.equals(null) || input.equals("")){

        }else {
            ReadCategories rc = new ReadCategories();
            output_id = rc.getMachingCategory(input);
        }

//        System.out.println("<><> " + input.toString() + " ><>< " + output_id.toString());
        return output_id;
    }
}
