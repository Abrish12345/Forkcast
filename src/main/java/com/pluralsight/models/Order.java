package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    //A LIST TO ADD ANY COMBINATION OF SANDWICHES, DRINKS AND CHIPS TO THE ORDER
    private List<OrderItem> items = new ArrayList<>();

    public void addItem(OrderItem item){
        items.add(item);
    }
    public List<OrderItem>getItems(){
        return items;
    }
    public double getTotalPrice(){
        return items.stream().mapToDouble(OrderItem->OrderItem.getPrice()).sum();
    }
}
