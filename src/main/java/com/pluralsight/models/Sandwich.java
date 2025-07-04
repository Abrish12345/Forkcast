package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich implements MenuItem {
    private String breadType;
    private String size;
    private boolean toasted;
    private List<String> meats;
    private List<String> cheeses;
    private List<String> regularToppings;
    private List<String> sauces;
    private List<String> extraCheese;
    private List<String> extraMeat;

    private double price;

    public Sandwich() {
        this.breadType = "Wheat";
        this.size = "8";
        this.toasted = false;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.extraMeat = new ArrayList<>();
        this.extraCheese = new ArrayList<>();
    }

    public Sandwich(String breadType, String size, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.meats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.extraMeat = new ArrayList<>();
        this.extraCheese = new ArrayList<>();
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public List<String> getMeats() {
        return meats;
    }

    public void setMeats(List<String> meats) {
        this.meats = meats;
    }

    public List<String> getCheeses() {
        return cheeses;
    }

    public void setCheeses(List<String> cheeses) {
        this.cheeses = cheeses;
    }

    public List<String> getRegularToppings() {
        return regularToppings;
    }

    public void setRegularToppings(List<String> regularToppings) {
        this.regularToppings = regularToppings;
    }

    public List<String> getSauces() {
        return sauces;
    }

    public void setSauces(List<String> sauces) {
        this.sauces = sauces;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void addMeat(String meat) {
        meats.add(meat);
    }

    public void addCheese(String cheese) {
        cheeses.add(cheese);
    }

    public void addRegularTopping(String topping) {
        regularToppings.add(topping);
    }

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    private double getMeatPrice(String size) {
        switch (size) {
            case "4":
                return 1.00;
            case "8":
                return 2.00;
            case "12":
                return 3.00;
            default:
                return 0;
        }
    }

    private double getCheesePrice(String size) {
        switch (size) {
            case "4":
                return 0.75;
            case "8":
                return 1.50;
            case "12":
                return 2.25;
            default:
                return 0;

        }

    }

    public void calculatePrice() {
        double basePrice = 0;
        switch (size) {
            case "4":
                basePrice = 5.50;
                break;
            case "8":
                basePrice = 7.00;
                break;
            case "12":
                basePrice = 8.50;
                break;
        }
        double meatPrice = meats.size() * getMeatPrice(size);
        double cheesePrice = cheeses.size() * getCheesePrice(size);
        double extraMeatPrice =extraMeat.size() * getExtraMeatPrice(size);
        double extraCheesePrice = extraCheese.size() * getExtraCheesePrice(size);

        //regular topping and sauces are free
        price = basePrice + meatPrice + cheesePrice + extraMeatPrice + extraCheesePrice;
    }


    @Override
    public String getDescription() {

        StringBuilder summery = new StringBuilder();
        summery.append(size).append("\" Sandwich on ").append(breadType);
        if (toasted) summery.append(" (toasted)");
        summery.append("\nMeat: ").append(meats.isEmpty() ? "None" : meats);
        summery.append(" (Extra Meat: ").append(extraMeat.isEmpty() ? "None" : extraMeat).append(")");
        summery.append("\nCheese: ").append(cheeses.isEmpty() ? "None" : cheeses);
        summery.append(" (Extra Cheese: ").append(extraCheese.isEmpty() ? "None" : extraCheese).append(")");
        summery.append("\nToppings: ").append(regularToppings.isEmpty() ? "None" : regularToppings);
        summery.append("\nSauces: ").append(sauces.isEmpty() ? "None" : sauces);
        return summery.toString();

    }

    @Override
    public double getPrice() {
        calculatePrice();//Ensure the price is always up to date
        return price;
    }

    @Override
    public String toString() {
        return getDescription();
    }



    public void addExtraCheese(String cheese) {
        extraCheese.add(cheese);

    }

    public void addExtraMeat(String meat) {
        extraMeat.add(meat);
    }

    public List<String> getExtraCheese() {
        return extraCheese;
    }

    public List<String> getExtraMeat() {
        return extraMeat;
    }

    private double getExtraMeatPrice(String size) {
        switch (size) {
            case "4":
                return 0.50;
            case "8":
                return 1.00;
            case "12":
                return 1.50;
            default:
                return 0;
        }
    }
    private double getExtraCheesePrice(String size) {
        switch (size) {
            case "4":
                return 0.30;
            case "8":
                return 0.60;
            case "12":
                return 0.90;
            default:
                return 0;
        }
    }
}
