package com.jars.shopping.ProductList;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

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

 /*   public void getNewProducts(@Observes ChosenCategories event) {
        // symulacja danych od Natali - 2xLista<String> -> event.categoriesEbay i event.categoriesAllegro
       /// List<String> categoriesEN = new ArrayList<String>();
       /// categoriesEN.add("CAT"); categoriesEN.add("DOG");


       List<Products> newAllProductsList = null;

        for(String nameCatE : event.categoriesEbay) {
            newAllProductsList.addAll(serviceEbay.getProductEbayListFromUrl(nameCatE.toString()));
        }

        for(String nameCatA : event.categoriesAllegro) {
            newAllProductsList.addAll(serviceAllegro.getProductAllegroListFromUrl(nameCatA.toString()));
        }

        eventList.fire(new ProductListEvent(newAllProductsList));

    }*/
}
