package com.jars.shopping.ProductList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class AllegroURL {
    @Produces
    @Named("allegroUrl")
    public String ebayUrl() {
        return "http://allegro.pl/some-cat-%s";
    }

}
