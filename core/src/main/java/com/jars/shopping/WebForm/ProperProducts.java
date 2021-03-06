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


    private Map<String, String> productListallegro = new HashMap<>();
    private Map<String, String> productListeBay = new HashMap<>();

    public Map<String, String> getProductListallegro() {
        return productListallegro;
    }
    public Map<String, String> getProductListeBay() { return productListeBay;    }

    public void getNewProducts(@Observes ProductListEvent event) {

        for (Products product : event.getAllProductsListAllegro()) {
            productListallegro.put(product.getUrl(), product.getProduct());
            LOGGER.info("added allegro: " + productListallegro.get(product.getUrl()));
        }
        for (Products product : event.getAllProductsListEbay()) {
            productListeBay.put(product.getUrl(), product.getProduct());
            LOGGER.info("added ebay:" + productListeBay.get(product.getUrl()));
        }
    }
}
