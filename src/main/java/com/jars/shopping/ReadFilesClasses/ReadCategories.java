package com.jars.shopping.ReadFilesClasses;

import com.jars.shopping.POJOs.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReadCategories {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadCategories.class);
    private static final Marker READ_CATEGORIES = MarkerFactory.getMarker("READ CATEG");

    private List<Category> categories = new ArrayList<Category>();

    public String getMachingCategory(String catName){
        LOGGER.info(READ_CATEGORIES,"Return matching category that contain catName");
        categories = this.getCategories();

        String categoryId ="";

        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getCatName().contains(catName)) {
                categoryId = String.valueOf(categories.get(i));
            }
        }

        LOGGER.info(READ_CATEGORIES,"Przygotuj numer kategorii, jeżeli istnienie w spisie");
        if(!categoryId.isEmpty() && !categoryId.equals("") && categoryId!=null) {
            categoryId = categoryId.substring(categoryId.indexOf("catId=") + 6, categoryId.indexOf("catName"));
        }

        return categoryId;

    }

    public List<Category> getMatchinCategories(String catName) {
        /** JS - 25 - return the list of categories that contain a specific string @param catName*/
        LOGGER.info(READ_CATEGORIES,"Return the list of matching categories that contain catName");
        List<Category> catNames = new ArrayList<Category>();
        categories = this.getCategories();

        for (int i = 0; i < categories.size(); i++) {
            int counter = 0;
            if (categories.get(i).getCatName().contains(catName)) {
                catNames.add(categories.get(i));
                counter++;
            }
        }
        return catNames;
    }

    public void printNMatchingCategories(int n, String catName) {
        LOGGER.info(READ_CATEGORIES,"Print matching categories in a list order");
        /** Prints out n matching categories */
        if (n > categories.size()) {
            n = categories.size();
            System.out.println("The desired amount of results, you've given " + n + " is larger than the size of the whole list");
        }
        if (n < 1) {
            throw new IllegalArgumentException("The amount of desired results cannot be less than 1");
        }
        List<Category> matchingCategories = new ArrayList<Category>();
        matchingCategories = getMatchinCategories(catName);
        //for (int i = 0; i < n; i++) System.out.println(matchingCategories.get(i));
        int counter = 0;
        for (Category c : matchingCategories) {
            System.out.println((counter + 1) + " -->  " + c.getCatName());
            counter++;
            if (counter == n) break;
        }
    }


    /**
     *
     * public String readResource(final String fileName, Charset charset) throws IOException {
     return Resources.toString(Resources.getResource(fileName), charset);
     }

     String fixture = this.readResource("filename.txt", Charsets.UTF_8)
     * Getter & Setterr
     */
    public List<Category> getCategories() {
        //Return ALL categories from XML file
        LOGGER.info(READ_CATEGORIES,"PREPARE list of categories from Allegro's xml file");
        try {
            URL resource = getClass().getClassLoader().getResource("Allegro_cathegories_2016-02-13.xml");
            //File fXmlFile = new File(URI.create("Allegro_cathegories_2016-02-13.xml"));
            File fXmlFile = new File("Allegro_cathegories_2016-02-13.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            //Document doc = dBuilder.parse(fXmlFile);
            Document doc = dBuilder.parse(resource.toExternalForm());

            //recommended to normalize
            doc.getDocumentElement().normalize();

            //System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("ns1:item");
            //System.out.println("We found " + nList.getLength() + " elements.");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    //add elements to Category class, create objects and parse to int
                    categories.add(new Category(
                            Integer.parseInt(eElement.getElementsByTagName("ns1:catId").item(0).getTextContent()),
                            eElement.getElementsByTagName("ns1:catName").item(0).getTextContent(),
                            Integer.parseInt(eElement.getElementsByTagName("ns1:catParent").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("ns1:catPosition").item(0).getTextContent()),
                            Integer.parseInt(eElement.getElementsByTagName("ns1:catIsProductCatalogueEnabled").item(0).getTextContent())));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return categories;
    }

    public void setCategories(List<Category> categories) {
        // Probably won't be needed, coulbe be needed if we will have to add new categories besides the ones that were
        // received from the Allegro XML.
        this.categories = categories;
    }
}






