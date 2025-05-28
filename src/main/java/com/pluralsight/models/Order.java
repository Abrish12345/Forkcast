package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Order {

    //A LIST TO HOLD ANY COMBINATION OF SANDWICHES, DRINKS AND CHIPS THAT IMPLEMENTS MENUITEM
    private List<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item){
        items.add(item);
    }
    public List<MenuItem>getItems(){
        return items;
    }
    public double getTotalPrice(){
        return items.stream().mapToDouble(OrderItem->OrderItem.getPrice()).sum();
    }

    //method to return order summary as a formated string
    public String getOrderSummary(){
        if (items.isEmpty()){
            return "No items in your order";
        }
        StringBuilder summary = new StringBuilder();
        summary.append("----Order Details----\n");
        for (MenuItem item: items){
            summary.append(item.getDescription())
                    .append(" - $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("\n");
        }
        return summary.toString();
    }
}
