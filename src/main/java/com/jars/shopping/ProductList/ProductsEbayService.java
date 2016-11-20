package com.jars.shopping.ProductList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
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

    public List<Products> translate(String input) {
        //final String urlString = String.format(ebayUrl, input);
       // final String urlString = String.format("http://www.ebay.com/sch/Puzzles");

        //https://jsoup.org/
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.ebay.com/sch/Puzzle").get();
            Elements resultLinks = doc.select("li#ListViewInner > li > h3#lvtitle");
                    //"<h3 class=\"lvtitle\"><a href=\"http://www.ebay.com/itm/500-PCS-PUZZLEBUG-PUZZLES-DOLPHIN-SONG-JIGSAW-PUZZLE-/222319612710?hash=item33c3481326:g:HWoAAOSwAuZX2ajm\" class=\"vip\" title=\"Click this link to access 500 PCS PUZZLEBUG PUZZLES DOLPHIN SONG JIGSAW PUZZLE\">500 PCS PUZZLEBUG PUZZLES DOLPHIN SONG JIGSAW PUZZLE</a>\n" +
                    //"\t\t</h3>:matches(regex)"); //31
            int i = 0;
            String s[] = new String[resultLinks.size()];
            for(Elements el : resultLinks){
                s[i++] = el.attr("values");
            }

            return resultLinks;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


       /* try {
            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            final Pattern pat = Pattern
                    //.compile(".*<a href=\"dict\\?words?=(.*)&lang.*");
                    .compile("\" class=\"img\" alt=\'(.*)'");

            List<String> allWords = reader.lines()
                    .map(s -> pat.matcher(s))   // do matching
                    .filter(Matcher::find)      // filter matches
                    .map(m -> m.group(m.groupCount())) // extract word
                    .collect(Collectors.toList());

            return IntStream.range(0, allWords.size())
                    //.filter(i -> i%2==0)
                    .mapToObj(i -> new Products(allWords.get(i)))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/
    }
}
