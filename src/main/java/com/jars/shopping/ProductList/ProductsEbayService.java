package com.jars.shopping.ProductList;


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

@Stateless
public class ProductsEbayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductsEbayService.class);
    private static final Marker PRODEBAYSERVICE = MarkerFactory.getMarker("PRODUCTS_EBAY_SERVICE");

    @Inject
    @Named("ebayUrl")
    String ebayUrl;

    public List<Products> translate(String input) {
        final String urlString = String.format(ebayUrl, input);
        //ex. http://www.ebay.com/sch/Puzzles

        LOGGER.info(PRODEBAYSERVICE,"Parsuj Ebay dla kategorii : " + input.toString());

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            final Pattern pat = Pattern
                    .compile("class=\"img\" alt=\'(.*)'");

            List<Products> allWordsEbay = reader.lines()
                    .map(s -> pat.matcher(s))   // do matching
                    .filter(Matcher::find)      // filter matches
                    .map(m -> m.group(m.groupCount())) // extract word
                    .map(Products::new)
                    .collect(Collectors.toList());

            return allWordsEbay;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
