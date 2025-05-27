package com.pluralsight.ui;

import java.util.Scanner; //import scanner to read user input

public class UserInterface {
    Scanner scanner = new Scanner(System.in); //create a scanner instance for input

    //Display the main menu where the user can start a new order or exist
    public void mainMenu() {

        System.out.println("1. New Order");     //menu option one
        System.out.println("0. Exit");         //menu option to exist
        String choice = scanner.nextLine();   //read users input

        switch (choice) {
            case "1":
                System.out.println("New Order");  //Display message
                orderScreen();                   //go to the order screen
                break;

            case "0":
                System.out.println("Exit"); //exit message
                break;

            default:
                System.out.println("Please chose either 'New Order' or 'Exit'"); //Error message
                mainMenu(); //Recalls menu if input is invalid
                break;

        }

    }

    //Display the order screen with options to add items or checkouts
    public void orderScreen() {
        System.out.println("1. Add Sandwich");      //option 1
        System.out.println("2. Add Drink");        //option 2
        System.out.println("3. Add Chips");       //option 3
        System.out.println("4. Checkout");       //option 4
        System.out.println("0. Cancel Order");  //option 0 to cancel

        String choice = scanner.nextLine();   //Read user input

        switch (choice) {

            case "1":
                System.out.println("Add Sandwich");           //Add sandwich options selected
                breadType();
                toasted();
                size();
                regularToppings();
                meat();
                cheese();
                sauces();
                break;
            case "2":
                System.out.println("Add Drink");
                drinks();                                   //Add drink options selected
                break;
            case "3":
                System.out.println("Add Chips");          //Add chips options selected
                chips();
                break;
            case "4":
                System.out.println("Checkout");         //proceed to checkout
                break;
            case "0":
                System.out.println("Cancel Order");   //order is cancelled
                break;
            default:
                System.out.println("please choose again"); //invalid input
                orderScreen();  //recall the order screen
                break;

        }
    }

    //prompts the user to choose a type of bread and handles their selections
    public void breadType() {
        //Display bread options to the user
        System.out.println("What type of bread do you want?");
        System.out.println("1) white");
        System.out.println("2) wheat");
        System.out.println("3) rye");
        System.out.println("4) wrap");

        //Read the user's input
        String choice = scanner.nextLine();

        //check the user's input and print the selected bread type
        if (choice.equals("1")) {
            System.out.println("you choice white bread");
        } else if (choice.equals("2")) {
            System.out.println("you chose wheat bread");
        } else if (choice.equals("3")) {
            System.out.println("you chose rye bread");
        } else if (choice.equals("4")) {
            System.out.println("you chose wrap bread");
        }

        //if the input is invalid, print an error message
        else {
            System.out.println("Please Enter Valid Number");
            //call breadType method to let the users try again
            breadType();
        }
    }


    //Prompts the customer to select a sandwich size and displays conformation
    public String size() {
        System.out.println("Select bread size  (4\", 8\" and 12\" ?");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");

        //read user input
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("you chose the size of 4 inches. ");
                return "4";
            case "2":
                System.out.println("you chose the size of 8 inches. ");
                return "8";
            case "3":
                System.out.println("you chose the size of 12 inches. ");
                return "12";
            default:
                System.out.println("Please choose a valid number.  ");
                return size();

        }

    }

    //Method to choose a list of regular toppings
    public void regularToppings() {
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

        String regularChoice = scanner.nextLine(); //read user input
        if (regularChoice.equals("0")) {
            System.out.println("No regular toppings added"); // if the user selects none
            return;

        }

        //split input by comma to handle multiple selections
        String[] choices = regularChoice.split(",");

        //loop through each selected choice
        for (String choice : choices) {
            switch (choice.trim()) { //remove extra spaces
                case "1":
                    System.out.println("Lettuce added");
                    break;
                case "2":
                    System.out.println("peppers added");
                    break;
                case "3":
                    System.out.println("Onions added");
                    break;
                case "4":
                    System.out.println("Tomatoes added");
                    break;
                case "5":
                    System.out.println("Jalapeños added");
                    break;
                case "6":
                    System.out.println("cucumbers added");
                    break;
                case "7":
                    System.out.println("Pickles added");
                    break;
                case "8":
                    System.out.println("Guacamole added");
                    break;
                case "9":
                    System.out.println("Mushrooms added");
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input
                    regularToppings();

            }

        }

    }

    //method to meatTopping
    public void meat() {
        System.out.println("Please chose your meat topping? ");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("0) None");

        //read user input
        String choice = scanner.nextLine();

        if (choice.equals("0")) {
            System.out.println("No meat toppings added"); // if the user selects none
            return;

        }

        //split input by comma to handle multiple selections
        String[] choices = choice.split(",");

        //loop through each selected choice
        for (String meatChoice : choices) {
            switch (meatChoice.trim()) { //remove extra spaces
                case "1":
                    System.out.println("Steak added");
                    break;
                case "2":
                    System.out.println("Ham added");
                    break;
                case "3":
                    System.out.println("Salami added");
                    break;
                case "4":
                    System.out.println("Roast Beef added");
                    break;
                case "5":
                    System.out.println("Chicken added");
                    break;
                case "6":
                    System.out.println("Bacon added");
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input
                    meat();
                    return;
            }

        }

    }

    public void cheese() {
        System.out.println("Please chose your cheese topping? ");
        System.out.println("1) american");
        System.out.println("2) provolone");
        System.out.println("3) cheddar");
        System.out.println("4) swiss");
        System.out.println("0) None");

        //read user input
        String choice = scanner.nextLine();

        if (choice.equals("0")) {
            System.out.println("No cheese toppings added"); // if the user selects none
            return;

        }

        //split input by comma to handle multiple selections
        String[] choices = choice.split(",");

        //loop through each selected choice
        for (String meatChoice : choices) {
            switch (meatChoice.trim()) { //remove extra spaces
                case "1":
                    System.out.println("American cheese added");
                    break;
                case "2":
                    System.out.println("Provolone cheese added");
                    break;
                case "3":
                    System.out.println("Cheddar cheese added");
                    break;
                case "4":
                    System.out.println("swiss cheese added");
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input
                    cheese();
                    return;
            }

        }

    }

    public void sauces() {
        System.out.println("Please chose your sauces topping? ");
        System.out.println("1) Mayo");
        System.out.println("2) Mustard");
        System.out.println("3) Ketchup");
        System.out.println("4) Ranch");
        System.out.println("5) Thousand islands");
        System.out.println("0) None");

        //read user input
        String sauceChoice = scanner.nextLine();

        if (sauceChoice.equals("0")) {
            System.out.println("No cheese toppings added"); // if the user selects none
            return;

        }

        //split input by comma to handle multiple selections
        String[] choices = sauceChoice.split(",");

        //loop through each selected choice
        for (String choice : choices) {
            switch (choice.trim()) { //remove extra spaces
                case "1":
                    System.out.println("Mayo added");
                    break;
                case "2":
                    System.out.println("Mustard added");
                    break;
                case "3":
                    System.out.println("Ketchup added");
                    break;
                case "4":
                    System.out.println("Ranch added");
                    break;
                case "5":
                    System.out.println("Thousand island added");
                    break;
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input

                    return;
            }

        }

    }

    public double drinks() {
        System.out.println("Would you like a drink?");
        System.out.println("1) small ($2.00)");
        System.out.println("2) medium ($2.50)");
        System.out.println("3) Large ($3.00)");
        System.out.println("0) None");

        String choice = scanner.nextLine();

        switch (choice) { //remove extra spaces
            case "1":
                System.out.println("Small drink added - $2.00");
                return 2.00;
            case "2":
                System.out.println("Medium drink added - $2.50");
                return 2.50;
            case "3":
                System.out.println("Large drink added - $3.00");
                return 3.00;
            case "0":
                System.out.println("No drink added.");
                return 0.00;
            default:
                System.out.println("Invalid choice: " + choice);//handle invalid input
                return drinks();

        }
    }

    public double chips() {
        System.out.println("would you like chips? ($1.50)");
        System.out.println("1) Yes");
        System.out.println("2) No");

        String choice = scanner.nextLine();
        switch (choice) { //remove extra spaces
            case "1":
                System.out.println("Chips added - $1.50");
                return 1.50;
            case "2":
                System.out.println("No chips added.");
                return 0.00;
            default:
                System.out.println("Invalid choice: " + choice);//handle invalid input
                return chips();

        }

    }

    public void toasted() {
        while (true) {
            System.out.println("Do you like your bread to be toasted? yes or no ");
            System.out.println("1) Yes");
            System.out.println("0) No");
            String choise = scanner.nextLine();
            switch (choise) {
                case "1":
                    System.out.println("You chose your bread to be toasted");
                    break;
                case "0":
                    System.out.println("You chose your bread to be not toasted");
                    break;
                default:
                    System.out.println("Please provide valid number (1 or 0)");

            }
        }
    }
}





