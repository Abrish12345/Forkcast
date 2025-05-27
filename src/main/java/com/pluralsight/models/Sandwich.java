package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements OrderItem{
private String breadType;
private String size;
private List<String>meats;
private List<String>cheeses;
private List<String>regularToppings;
private List<String> sauces;

private double price;

    public Sandwich(String breadType, String size) {
        this.breadType = breadType;
        this.size = size;
        this.meats=new ArrayList<>();
        this.cheeses= new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
    }
    public void addMeat(String meat){
        meats.add(meat);
    }
    public void addCheese(String cheese){
        cheeses.add(cheese);
    }
    public void addTopping(String topping){
        regularToppings.add(topping);
    }
    public void addSauce(String sauce){
        sauces.add(sauce);
    }
    private double getMeatPrice(String size){
        switch (size){
            case "4": return 1.00;
            case "8": return 2.00;
            case "12": return 3.00;
            default:return 0;
        }
    }

private double getCheesePrice(String size){
        switch(size){
            case "4": return 0.75;
            case "8": return 1.50;
            case "12": return 2.25;
            default:return 0;

        }
}


    @Override
    public String getName() {
        return size + "\" Sandwich on" + breadType;
    }
    @Override
    public double getPrice() {
        return price;
    }
}
