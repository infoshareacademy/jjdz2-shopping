package com.jars.shopping.ReadFilesClasses;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadCategoriesTest {
    @Test
    public void shouldreturn(){
     ReadCategories somename = new ReadCategories();
        somename.getCategories();
    }
}