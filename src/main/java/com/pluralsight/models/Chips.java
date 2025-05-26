package com.pluralsight.models;

public class Chips implements OrderItem{
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }
}
