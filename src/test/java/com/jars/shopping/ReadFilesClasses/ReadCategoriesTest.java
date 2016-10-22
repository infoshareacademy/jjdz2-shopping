package com.jars.shopping.ReadFilesClasses;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadCategoriesTest {
    @Test
    public void should_return_categories(){
        ReadCategories somename = new ReadCategories();
        assertNotNull(somename.getCategories());
    }
}