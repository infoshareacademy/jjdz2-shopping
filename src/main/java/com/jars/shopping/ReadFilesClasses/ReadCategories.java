package com.jars.shopping.ReadFilesClasses;

import com.jars.shopping.POJOs.Category;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class ReadCategories {

    private List<Category> categories = new ArrayList<Category>();

    public List<Category> getMatchinCategories(String catName) {
        /** JS - 25 - return the list of categories that contain a specific string @param catName*/

        List<Category> catNames = new ArrayList<Category>();

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
     * Getter & Setterr
     */
    public List<Category> getCategories() {
        //Return ALL categories from XML file

        try {
            URL resource = getClass().getClassLoader().getResource("Allegro_cathegories_2016-02-13.xml");
            File fXmlFile = new File(resource.toURI());

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

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






