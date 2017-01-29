package com.jars.shopping.ProductList;

import javax.persistence.*;

/**
 * Created by marcinpankowski on 20.11.16.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = Products.GET_PRODUCTS_LIST,
                query = "select p " +
                        "from Products p"),
        @NamedQuery(name = Products.GET_PRODUCTS_LIST_BY_USER,
                query = "select p " +
                        "from Products p " +
                        "where p.user=:userToGet"),
        @NamedQuery(name = Products.DEL_PRODUCT_BY_URL,
                query = "delete " +
                        "from Products AS p " +
                        "where p.url=:urlToDel and p.user=:userToDel")
})

public class Products {
    final public static String GET_PRODUCTS_LIST = "Products.GET_PRODUCTS_LIST";
    final public static String DEL_PRODUCT_BY_URL = "Products.DEL_PRODUCT_BY_URL";
    final public static String GET_PRODUCTS_LIST_BY_USER = "Products.GET_PRODUCTS_LIST_BY_USER";

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String product;
    private String url;
    private String user;

    public Products() {
    }

    public Products(String product, String url) {
        this.product = product;
        this.url = url;
    }

    public Products(String product, String url, String user) {
        this.product = product;
        this.url = url;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Products{" + "product='" + product + "'" + " url='" + url + "'" + " user='" + user + '}' + '\'';
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Products(String product) {

        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
