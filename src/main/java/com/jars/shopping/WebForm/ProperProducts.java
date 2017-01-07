package com.jars.shopping.WebForm;

import com.jars.shopping.ProductList.ProductListEvent;
import com.jars.shopping.ProductList.Products;

import javax.enterprise.event.Observes;

public class ProperProducts {

    public void getNewProducts(@Observes ProductListEvent event) {

        for (Products product : event.getAllProductsList()) {

        }
    }
}
