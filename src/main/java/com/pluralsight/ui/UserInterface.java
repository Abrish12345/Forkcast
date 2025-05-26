package com.pluralsight.ui;

import java.util.Scanner; //import scanner to read user input

public class UserInterface {
    Scanner scanner = new Scanner(System.in); //create a scanner instance for input

    //Display the main menu where the user can start a new order or exist
    public void menuMenu(){

        System.out.println("1. New Order");  //menu option one
        System.out.println("0. Exit");  //menu option to exist
        String choice = scanner.nextLine(); //read users input

        switch (choice) {
        case "1":
        System.out.println("New Order"); //Display message
        orderScreen(); //go to the order screen
        break;

            case "0":
                System.out.println("Exit"); //exit message
                break;

            default:
                System.out.println("Please chose ether New Order and Exit"); //Error message
                menuMenu(); //Recalls menu if input is invalid
                break;

        }

    }
    //Display the order screen with options to add items or checkouts
    public void orderScreen(){
        System.out.println("1. Add Sandwich");      //option 1
        System.out.println("2. Add Drink");        //option 2
        System.out.println("3. Add Chips");       //option 3
        System.out.println("4. Checkout");       //option 4
        System.out.println("0. Cancel Order");  //option 0 to cancel

        String choise = scanner.nextLine();   //Read user input

        switch (choise){

            case "1":
                System.out.println("Add Sandwich");     //Add sandwich options selected
                break;
            case "2":
                System.out.println("Add Drink");       //Add drink options selected
                break;
            case "3":
                System.out.println("Add Chips");      //Add chips options selected
                break;
            case "4":
                System.out.println("Checkout");      //proceed to checkout
                break;
            case "0":
                System.out.println("Cancel Order");  //order is cancelled
                break;
            default:
                System.out.println("please choose again"); //invalid input
                orderScreen();  //recall the order screen
                break;

        }
    }


    
    //Method to chose a list of regular toppings
    public void chooseRegularToppings(){
        System.out.println("Choose your regular toppings: ");
        System.out.println("1) Lettuce");
        System.out.println("2) peppers");
        System.out.println("3) Onions");
        System.out.println("4) Tomatoes");
        System.out.println("5) Jalapeños");
        System.out.println("6) cucumbers");
        System.out.println("7) pickles");
        System.out.println("8) Guacamole");
        System.out.println("9) Mushrooms");
        System.out.println("0) None");

        String regularChoice =scanner.nextLine(); //read user input
        if (regularChoice.equals("0")){
            System.out.println("No regular toppings added"); // if the user selects none
            return;

        }

        //split input by comma to handle multiple selections
        String[] choices = regularChoice.split(",");

        //loop through each selected choice
        for(String choice : choices) {
            switch (choice.trim()){ //remove extra spaces
                case "1": System.out.println( "Lettuce added"); break;
                case "2": System.out.println("peppers added");break;
                case "3": System.out.println("Onions added");break;
                case "4": System.out.println("Tomatoes added");break;
                case "5": System.out.println("Jalapeños added");break;
                case "6": System.out.println("cucumbers added");break;
                case "7": System.out.println("Pickles added");break;
                case "8": System.out.println("Guacamole added");break;
                case "9": System.out.println("Mushrooms added");break;
                default: System.out.println("Invalid choice: " + choice);break;  //handle invalid input
            }

        }

    }

}
