package com.pluralsight.models;

public class Chips implements MenuItem {
    private String name;
    private double price = 1.50;

    public Chips(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return name + "Chips";
    }
    @Override
    public double getPrice() {
        return price;
    }
}
