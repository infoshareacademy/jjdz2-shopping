package com.jars.shopping.ProductList;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by marcinpankowski on 20.11.16.
 */
public class ProductsEbayServiceTest {



    @Test
    public void testTranslate() throws Exception {
        ProductsEbayService productsEbayService = new ProductsEbayService();
        productsEbayService.ebayUrl = "http://www.ebay.com/sch/%s";
        List<Products> listOfProducts = productsEbayService.translate("Puzzles");

        assertNotNull(listOfProducts.size());
    }




}