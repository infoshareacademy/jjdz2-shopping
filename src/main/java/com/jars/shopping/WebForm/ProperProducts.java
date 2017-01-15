package com.jars.shopping.WebForm;

import com.jars.shopping.ProductList.ProductListEvent;
import com.jars.shopping.ProductList.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ProperProducts {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProperProducts.class);


    private Map<String, String> productList = new HashMap<>();

    public Map<String, String> getProductList() {
        return productList;
    }

    public void getNewProducts(@Observes ProductListEvent event) {

        for (Products product : event.getAllProductsListAllegro()) {
            productList.put(product.getUrl(),product.getProduct());
            LOGGER.info("added " + productList.get(product.getUrl()));
        }
    }
}
