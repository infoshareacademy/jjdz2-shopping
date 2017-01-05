package com.jars.shopping.ProductList;

import java.util.List;

/**
 * Created by marcinpankowski on 18.12.16.
 */
public class ProductListEvent {
    private List<Products> allProductsList;


    public ProductListEvent(List<Products> allProductsList) {
        this.allProductsList = allProductsList;
    }

    public List<Products> getAllProductsList() {
        return allProductsList;
    }

    public void setAllProductsList(List<Products> allProductsList) {
        this.allProductsList = allProductsList;
    }
}
