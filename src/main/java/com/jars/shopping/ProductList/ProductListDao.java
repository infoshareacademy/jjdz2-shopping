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

            String stProductName = st.substring(0, st.indexOf("+"));
            String stUrl = st.substring(st.indexOf("+") + 1, st.length());
            LOGGER.info(PRODUCTLISTDAO, "Nowy ProductName " + stProductName.toString());
            LOGGER.info(PRODUCTLISTDAO, "Nowy Url " + stUrl.toString());

            Products pr = new Products(stProductName.toString(), stUrl.toString(), user);

            if (chackIfUnique(stProductName,stUrl,user)) {
                entityManager.persist(pr);
                LOGGER.info(PRODUCTLISTDAO, "Dodano nowy produkt do zapisanych elementów: " + st.toString());
            } else {
                LOGGER.info(PRODUCTLISTDAO, "Podany produkt już istnieje: " + st.toString());
            }
        }
    }

    private boolean chackIfUnique(String stProductName, String stUrl, String user) {
        List<Products> allProductsList = getProducts();
        for (Products prod : allProductsList) {
            if (prod.getProduct().equals(stProductName) && prod.getUrl().equals(stUrl) && prod.getUser().equals(user)) {
                return false;
            }
        }
        return true;
    }

    public void delProductByUrl(String url) {
        entityManager.createNamedQuery(Products.DEL_PRODUCT_BY_URL).setParameter("urlToDel", url).executeUpdate();
    }

    public List<Products> getProducts() {
        List<Products> productListFromDB = null;

        LOGGER.info(PRODUCTLISTDAO, "Sprawdzamy listę produktów");
        productListFromDB = entityManager.createNamedQuery(Products.GET_PRODUCTS_LIST, Products.class).getResultList();

        return productListFromDB;
    }

}
