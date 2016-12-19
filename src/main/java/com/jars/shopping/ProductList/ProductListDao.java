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

    public void addListProducts(String[] listOfProd, String user) {
        for (String st : listOfProd) {

            String stProductName = st.substring(0,st.indexOf("+"));
            String stUrl = st.substring(st.indexOf("+")+1,st.length());

           // Products pr = new Products(st, user);
            Products pr = new Products(stProductName,stUrl , user);

            if(chackIfUnique(st)){
                entityManager.persist(pr);
                LOGGER.info(PRODUCTLISTDAO,"Dodano nowy produkt do zapisanych elementów: " + st.toString());
            }else{
                LOGGER.info(PRODUCTLISTDAO, "Podany produkt już istniejie: " + st.toString());
            }
        }
    }

    private boolean chackIfUnique(String st) {
        List<Products> allProductsList = getProducts();
        for(Products prod:allProductsList){
            if(prod.getProduct().equals(st)){
                return false;
            }
        }
        return true;
    }

    public List<Products> getProducts(){
        List<Products> someName=null;

            LOGGER.info(PRODUCTLISTDAO, "Sprawdzamy listę produktów");
            someName = entityManager.createNamedQuery(Products.GET_PRODUCTS_LIST, Products.class).getResultList();
//
//        for(Products sn : someName){
//            System.out.println(sn.getId() + sn.getProduct() + sn.getUser());
//        }

        return someName;
    }

}
