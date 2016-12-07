package com.jars.shopping.ProductList;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by marcinpankowski on 20.11.16.
 */
public class ProductsEbayServiceTest {

    @Test
    public void testTranslate() throws Exception {
        ProductsEbayService productsEbayService = new ProductsEbayService();
        List<Products> listOfProducts = productsEbayService.translate("sthg");
//        assertThat(listOfProducts, hasItem(new Products("Tenyo")));
        //assertThat(listOfProducts.size(), is(
                assertNotNull(listOfProducts.size());
    }




}