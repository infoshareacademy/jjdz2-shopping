package com.jars.shopping.POJOs;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


/**
 * Created by marcinpankowski on 09.10.16.
 */
public class CategoryTest {
    static Category category;
    static final String ROWERY = "rowery";
    public static final List<Category> CATEGORIES = Arrays.asList(
                        new Category(11,"rowery",22,33,44),
                        new Category(12,"samochody",23,34,45),
                        new Category(13,"motocykle",24,35,46)
    );

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

    // Tests in java8
    @Test
    public void shouldReturnCategoriesSorted() {
        final List<String> listCategories = CATEGORIES.
                stream().
                map(Category::getCatName).
                sorted().
                collect(Collectors.toList());
        assertThat(listCategories).containsExactly("motocykle","rowery","samochody");
    }

    @Test
    public void doesAnyBikesExist() {
        final boolean roweryCategories = CATEGORIES.
                stream().
                anyMatch(p -> p.getCatName() == ROWERY);

        assertThat(roweryCategories).isTrue();
    }


    @Test
    public void shouldSortByCatId() throws IOException {
               final List<String> categoriesWithId = CATEGORIES.stream().
                map(p -> p.getCatName() + '-' + p.getCatId()).
                collect(toList());

        assertThat(categoriesWithId).startsWith("rowery-11","samochody-12","motocykle-13");
    }
}