package com.pluralsight.models;

import java.text.Normalizer;
/*
public class Topping {

    //initializing the properties
    private String name;
    private String category;
    private boolean isExtra;
    private double basePrice;

    // constructor
    public Topping(String name, String categories, boolean isExtra, double basePrice) {
        this.name = name;
        this.category = categories;
        this.isExtra = isExtra;
        this.basePrice = basePrice;

    }

    //generate getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return category;
    }

    public void setCategories(String categories) {
        this.category = categories;
    }

    public boolean getIsExtra() {
        return isExtra;
    }

    public void setIsExtra(boolean isExtra) {
        this.isExtra = isExtra;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double regularPrice(double size) {

        if (category.equalsIgnoreCase("Regular")) {
            return 0;
        } else {
         //   perimumPrice(size);
        }
    }
}


    }

    public double perimumPrice(double size) {
        double noramlPrice = 0;

        if (category.equalsIgnoreCase("Perimum")) {
            return noramlPrice;
        }
}
    /*
    //toping name ->meat if the size is 4

     */







