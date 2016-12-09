package com.jars.shopping.ProductList;

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

    @Inject
    @Named("allegroUrl")
    String allegroUrl;

    public List<Products> translate(String input) {

        String catValue = generateValueForAllegro(input);
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
        //link to allegro can not be empty as not to hit 404 no-page information
        if(input.equals(null) || input.equals("")){
          input="325";
            System.out.println("inside ><> ");
        }
        System.out.println("outside <>< ");
        return input;
    }
}
