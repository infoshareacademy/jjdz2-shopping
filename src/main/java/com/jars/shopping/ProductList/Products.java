package com.jars.shopping.ProductList;

/**
 * Created by marcinpankowski on 20.11.16.
 */
public class Products {
    private String product;

    @Override
    public String toString() {
        return "Products{" + "product='" + product + '}' + '\'';
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Products(String product) {

        this.product = product;
    }
}
