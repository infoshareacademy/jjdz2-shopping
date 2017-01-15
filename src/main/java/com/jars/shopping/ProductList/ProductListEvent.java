package com.jars.shopping.ProductList;

import java.util.List;

/**
 * Created by marcinpankowski on 18.12.16.
 */
public class ProductListEvent {
    private List<Products> allProductsListAllegro;
    private List<Products> allProductsListEbay;


    public ProductListEvent(List<Products> allProductsListEbay,List<Products>  allProductsListAllegro) {
        this.allProductsListEbay = allProductsListEbay;
        this.allProductsListAllegro = allProductsListAllegro;
    }



    public List<Products> getAllProductsListEbay() {
        return allProductsListEbay;
    }

    public void setAllProductsListEbay(List<Products> allProductsListEbay) {
        this.allProductsListEbay = allProductsListEbay;
    }

    public List<Products> getAllProductsListAllegro() {
        return allProductsListAllegro;
    }

    public void setAllProductsListAllegro(List<Products> allProductsListAllegro) {
        this.allProductsListAllegro = allProductsListAllegro;
    }
}
