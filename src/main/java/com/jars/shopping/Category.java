package com.jars.shopping;

/**
 * Created by marcinpankowski on 11.09.16.
 */
public class Category {

    private int catId;
    private String catName;
    private int catParent;
    private int catPosition;
    private int catIsProductCatalogueEnabled;


    public Category(int catId, String catName, int catParent, int catPosition, int catIsProductCatalogueEnabled) {
        this.catId = catId;
        this.catName = catName;
        this.catParent = catParent;
        this.catPosition = catPosition;
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatParent() {
        return catParent;
    }

    public void setCatParent(int catParent) {
        this.catParent = catParent;
    }

    public int getCatPosition() {
        return catPosition;
    }

    public void setCatPosition(int catPosition) {
        this.catPosition = catPosition;
    }

    public int getCatIsProductCatalogueEnabled() {
        return catIsProductCatalogueEnabled;
    }

    public void setCatIsProductCatalogueEnabled(int catIsProductCatalogueEnabled) {
        this.catIsProductCatalogueEnabled = catIsProductCatalogueEnabled;
    }





}
