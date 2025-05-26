package com.pluralsight.models;

public class Drink implements OrderItem{
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
