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

        LOGGER.info(PRODALLEGROSERVICE,"Parsuj Allegro dla kategorii : " + catValue.toString());
        final String urlString = String.format(allegroUrl, catValue);

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            final Pattern pat = Pattern
            .compile("class=\"offer-title\" href=\".*\">(.*)</a>");

            List<String> allWords = reader.lines()
                    .map(s -> pat.matcher(s))   // do matching
                    .filter(Matcher::find)      // filter matches
                    .map(m -> m.group(m.groupCount())) // extract word
                    .collect(Collectors.toList());

            return IntStream.range(0, allWords.size())
                    .mapToObj(i -> new Products(allWords.get(i)))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateValueForAllegro(String input) {
        LOGGER.info(PRODALLEGROSERVICE,"Pobierz nazwę kategorii dla Allegro, z nr: " + input.toString());
        //TO DO
        ReadCategories rc = new ReadCategories();
        String output_id = rc.getMachingCategory(input);

        System.out.println(">>>>>>>>>> " + output_id + ">> " + input);

        if(input.equals(null) || input.equals("")){
            LOGGER.info(PRODALLEGROSERVICE,"Ustaw defaultową kategorię - aby nie było błędu 404");
            input="325";
        }

        return output_id;
    }
}
