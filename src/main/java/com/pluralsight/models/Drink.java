package com.pluralsight.models;

public class Drink implements MenuItem {
    private String name;
    private String size;
    private double price;

    public Drink(String name, String size) {
        this.name = name;
        this.size = size;
        switch (size){
            case "Small":price =2.00;break;
            case "Medium": price=2.50;break;
            case "Large":price=3.00;break;
        }

    }
    @Override
    public String getDescription() {
        return size + " " + name;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
