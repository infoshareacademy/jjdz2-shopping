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
public class ProductsEbayService {

    //@Inject
    //@Named("ebayUrl")
    //String ebayUrl;

    public List<Word> translate(String input) {
        //final String urlString = String.format(ebayUrl, input);
        final String urlString = String.format("http://www.ebay.com/sch/Puzzles");

        try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            final Pattern pat = Pattern
                    .compile(".*<a href=\"dict\\?words?=(.*)&lang.*");

            List<String> allWords = reader.lines()
                    .map(s -> pat.matcher(s))   // do matching
                    .filter(Matcher::find)      // filter matches
                    .map(m -> m.group(m.groupCount())) // extract word
                    .collect(Collectors.toList());

            return IntStream.range(0, allWords.size())
                    .filter(i -> i%2==0)
                    .mapToObj(i -> new Word(allWords.get(i), allWords.get(i+1)))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
