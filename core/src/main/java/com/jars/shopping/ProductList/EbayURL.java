package com.jars.shopping.ProductList;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@ApplicationScoped
public class EbayURL {
    @Produces
    @Named("ebayUrl")
    public String ebayUrl() {
        return "http://www.ebay.com/sch/%s";
    }

}
