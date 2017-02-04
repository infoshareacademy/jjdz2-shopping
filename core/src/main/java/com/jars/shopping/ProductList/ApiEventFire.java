package com.jars.shopping.ProductList;

/**
 * Created by keehoo on 04.02.17.
 */
public class ApiEventFire {

    String product;

    public ApiEventFire(String product, String userName) {
        this.product = product;
        this.userName = userName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String userName;


}
