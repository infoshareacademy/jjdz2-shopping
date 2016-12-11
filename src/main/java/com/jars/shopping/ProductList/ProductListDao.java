package com.jars.shopping.ProductList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by marcinpankowski on 10.12.16.
 */
@Stateless
public class ProductListDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListDao.class);
    private static final Marker PRODUCTLISTDAO = MarkerFactory.getMarker("PRODUCT_LIST_DAO");

    @PersistenceContext
    EntityManager entityManager;

    public void addListProducts(String[] listofprod, String user) {
        for (String st : listofprod) {
            Products pr = new Products(st, user);

            if (!getProducts().contains(pr.getProduct())){
                entityManager.persist(pr);
                LOGGER.info(PRODUCTLISTDAO,"Dodano nowy produkt do zapisanych elementów: " + st.toString());
            }else{
                LOGGER.info(PRODUCTLISTDAO,"Podany produkt już istniejie: " + st.toString());
            }

        }
    }

    public List<Products> getProducts(){
        LOGGER.info(PRODUCTLISTDAO,"Sprawdzamy listę produktów");
        List<Products> someName = entityManager.createNamedQuery(Products.GET_PRODUCTS_LIST, Products.class).getResultList();

        return someName;
    }

}
