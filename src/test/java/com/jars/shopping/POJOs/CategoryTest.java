package com.jars.shopping.POJOs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by marcinpankowski on 09.10.16.
 */
public class CategoryTest {
    static Category category;

    @Before
    public void set_up_artificial_category(){
        category = new Category(1,"bicycles",2,3,4);
    }

    @Test
    public void testGetCatName() throws Exception {
        assertEquals("bicycles",category.getCatName());
    }

    @Test
    public void testSetCatName() throws Exception {
        String newName = "rowery";
        category.setCatName(newName);
        assertEquals(newName, category.getCatName());
    }
}