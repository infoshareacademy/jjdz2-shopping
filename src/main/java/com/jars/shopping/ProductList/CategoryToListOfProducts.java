package com.jars.shopping.ProductList;

import com.jars.shopping.WebForm.ChosenCategories;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcinpankowski on 18.12.16.
 */
@Stateless
public class CategoryToListOfProducts {
    @Inject
    Event<ProductListEvent> eventList;

    @EJB
    ProductsEbayService serviceEbay;

    @EJB
    ProductsAllegroService serviceAllegro;

  public void getNewProducts(@Observes ChosenCategories event) {
        // symulacja danych od Natali - 2xLista<String> -> event.categoriesEbay i event.categoriesAllegro
       /// List<String> categoriesEN = new ArrayList<String>();
       /// categoriesEN.add("CAT"); categoriesEN.add("DOG");


       List<Products> newAllProductsListEbay = new ArrayList<>();
       List<Products> newAllProductsListAllegro = new ArrayList<>();


        for(String nameCatE : event.getEbay()){
            nameCatE = nameCatE.replaceAll("\\s","");
            newAllProductsListEbay.addAll(serviceEbay.getProductEbayListFromUrl(nameCatE.toString()));
        }

        for(String nameCatA : event.getAllegro()) {
            newAllProductsListAllegro.addAll(serviceAllegro.getProductAllegroListFromUrl(nameCatA.toString()));
        }

        eventList.fire(new ProductListEvent(newAllProductsListEbay, newAllProductsListAllegro));

    }
}
