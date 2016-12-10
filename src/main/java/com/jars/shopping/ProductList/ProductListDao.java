package com.jars.shopping.ProductList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by marcinpankowski on 10.12.16.
 */
@Stateless
public class ProductListDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductListDao.class);
    private static final Marker PRODUCTLISTDAO = MarkerFactory.getMarker("PRODUCT_LIST_DAO");

    @PersistenceContext
    EntityManager entityManager;

    public void addListProducts(String[] listofprod) {
        for (String st : listofprod) {
            Products pr = new Products(st);

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

  /*      List<Products> sN = IntStream.range(0, someName.size())
                .mapToObj(i -> new Products(someName.get(i)))
                .collect(Collectors.toList());

        for(Products p:sN){
            LOGGER.info(PRODUCTLISTDAO,"id: " + p.getId());
        }
*/
        return someName;
    }

}
