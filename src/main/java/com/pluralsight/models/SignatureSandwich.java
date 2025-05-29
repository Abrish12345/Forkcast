package com.pluralsight.models;

public class SignatureSandwich extends Sandwich{
    private String name;

    public SignatureSandwich(String name){
        super(); //call to sandwich constructor
        this.name =name;

        //configure based on the name
        switch (name.toUpperCase()){
            case "blt":
                setSize("8");
                setBreadType("white");
                setToasted(true);
                addMeat("bacon");
                addCheese("cheddar");
                addRegularTopping("Lettuce");
                addRegularTopping("tomato");
                addSauce("ranch");
                break;
            case"philly cheese steak":
                setSize("8");
                setBreadType("white");
                setToasted(true);
                addMeat("bacon");
                addCheese("cheddar");
                addRegularTopping("Lettuce");
                addSauce("mayo");
                break;

        }
    }
    @Override
    public String getDescription(){
        return name + "Sandwich -" + super.getDescription();

    }
}

