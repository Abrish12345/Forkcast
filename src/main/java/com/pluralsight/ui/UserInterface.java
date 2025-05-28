package com.pluralsight.ui;

import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; //import scanner to read user input

public class UserInterface {
    private Order currentOrder= new Order();
    Scanner scanner = new Scanner(System.in); //create a scanner instance for input

    //Display the main menu where the user can start a new order or exist
    public void mainMenu() {
        while(true){

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
                return; //exit the method

            default:
                System.out.println("Please chose either 'New Order' or 'Exit'"); //Error message
                break;

            }
        }

    }

    //Display the order screen with options to add items or checkouts
    public void orderScreen() {
        while (true){
        System.out.println("1. Add Sandwich");      //option 1
        System.out.println("2. Add Drink");        //option 2
        System.out.println("3. Add Chips");       //option 3
        System.out.println("4. Checkout");       //option 4
        System.out.println("0. Cancel Order");  //option 0 to cancel

        String choice = scanner.nextLine();   //Read user input

        switch (choice) {

            case "1":
                System.out.println("Add Sandwich");           //Add sandwich options selected
                Sandwich sandwich = new Sandwich();
                size(sandwich);
                breadType(sandwich);
                boolean isToasted = toasted();
                sandwich.setToasted(isToasted);
                regularToppings(sandwich);
                meat(sandwich);
                cheese(sandwich);
                sauces(sandwich);

                //add the sandwich to the current order after finishing customization
                currentOrder.addItem(sandwich);
                System.out.println("Sandwich added to your order. ");

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
                checkOut();
                System.out.println("Checkout");         //proceed to checkout
                break;
            case "0":
                System.out.println("Cancel Order");   //order is cancelled
                currentOrder = new Order(); //CLEAR CURRENT ORDER IF WE WANT TO DISCARD
                break;
            default:
                System.out.println("please choose again"); //invalid input

            }
        }
    }

    //prompts the user to choose a type of bread and handles their selections
    public void breadType(Sandwich sandwich) {
        //Display bread options to the user
        while (true) {
            System.out.println("What type of bread do you want?");
            System.out.println("1) white");
            System.out.println("2) wheat");
            System.out.println("3) rye");
            System.out.println("4) wrap");

            //Read the user's input
            String choice = scanner.nextLine();

            //check the user's input and print the selected bread type
            if (choice.equals("1")) {
                sandwich.setBreadType("white");
                System.out.println("you choice white bread");
                return;
            } else if (choice.equals("2")) {
                sandwich.setBreadType("wheat");
                System.out.println("you chose wheat bread");
                return;
            } else if (choice.equals("3")) {
                sandwich.setBreadType("rye");
                System.out.println("you chose rye bread");
                return;
            } else if (choice.equals("4")) {
                sandwich.setBreadType("wrap");
                System.out.println("you chose wrap bread");
                return;
            }

            //if the input is invalid, print an error message
            else {
                System.out.println("Please Enter Valid Number");
                //call breadType method to let the users try again

            }
        }
    }


    //Prompts the customer to select a sandwich size and displays conformation
    public void size(Sandwich sandwich) {
        while (true) {
            System.out.println("Select bread size  (4\", 8\" and 12\" ?");
            System.out.println("1) 4 inch");
            System.out.println("2) 8 inch");
            System.out.println("3) 12 inch");

            //read user input
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.setSize("4");
                    System.out.println("you chose the size of 4 inches. ");
                    return;
                case "2":
                    sandwich.setSize("8");
                    System.out.println("you chose the size of 8 inches. ");
                    return;
                case "3":
                    sandwich.setSize("12");
                    System.out.println("you chose the size of 12 inches. ");
                    return;
                default:
                    System.out.println("Please choose a valid number.  ");
                    break;


            }

        }
    }

    //Method to choose a list of regular toppings
    public void regularToppings(Sandwich sandwich) {
        while (true) {

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
                        sandwich.addRegularTopping("Lettuce");
                        System.out.println("Lettuce added");
                        break;
                    case "2":
                        sandwich.addRegularTopping("peppers");
                        System.out.println("peppers added");
                        break;
                    case "3":
                        sandwich.addRegularTopping("Onions");
                        System.out.println("Onions added");
                        break;
                    case "4":
                        sandwich.addRegularTopping("Tomatoes");
                        System.out.println("Tomatoes added");
                        break;
                    case "5":
                        sandwich.addRegularTopping("Jalapeños");
                        System.out.println("Jalapeños added");
                        break;
                    case "6":
                        sandwich.addRegularTopping("cucumbers");
                        System.out.println("cucumbers added");
                        break;
                    case "7":
                        sandwich.addRegularTopping("pickles");
                        System.out.println("Pickles added");
                        break;
                    case "8":
                        sandwich.addRegularTopping("Guacamole");
                        System.out.println("Guacamole added");
                        break;
                    case "9":
                        sandwich.addRegularTopping("Mushrooms");
                        System.out.println("Mushrooms added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input
                        break;


                }

            }
            return;

        }
    }

    //method to meatTopping
    public void meat(Sandwich sandwich) {
        while (true) {
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
                        sandwich.addMeat("Steak");
                        System.out.println("Steak added");
                        break;
                    case "2":
                        sandwich.addMeat("Ham");
                        System.out.println("Ham added");
                        break;
                    case "3":
                        sandwich.addMeat("Salami");
                        System.out.println("Salami added");
                        break;
                    case "4":
                        sandwich.addMeat("Roast Beef");
                        System.out.println("Roast Beef added");
                        break;
                    case "5":
                        sandwich.addMeat("Chicken");
                        System.out.println("Chicken added");
                        break;
                    case "6":
                        sandwich.addMeat("Bacon");
                        System.out.println("Bacon added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input

                        break;
                }

            }
            return;

        }
    }
    public void cheese(Sandwich sandwich) {
        while (true) {
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
                        sandwich.addCheese("american");
                        System.out.println("American cheese added");
                        break;
                    case "2":
                        sandwich.addCheese("provolone");
                        System.out.println("Provolone cheese added");
                        break;
                    case "3":
                        sandwich.addCheese("cheddar");
                        System.out.println("Cheddar cheese added");
                        break;
                    case "4":
                        sandwich.addCheese("swiss");
                        System.out.println("swiss cheese added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input

                        break;
                }

            }
            return;

        }
    }
    public void sauces(Sandwich sandwich) {
        while (true) {
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
                        sandwich.addSauce("Mayo");
                        System.out.println("Mayo added");
                        break;
                    case "2":
                        sandwich.addSauce("Mustard");
                        System.out.println("Mustard added");
                        break;
                    case "3":
                        sandwich.addSauce("Ketchup");
                        System.out.println("Ketchup added");
                        break;
                    case "4":
                        sandwich.addSauce("Ranch");
                        System.out.println("Ranch added");
                        break;
                    case "5":
                        sandwich.addSauce("Thousand islands");
                        System.out.println("Thousand island added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input

                        break;
                }
                return;

            }

        }
    }
    public double drinks() {
        while (true) {
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
                    break;
            }

        }
    }
    public double chips() {
        while (true) {
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
                    break;

            }


        }
    }
    public boolean toasted() {
        while (true) {
            System.out.println("Do you like your bread to be toasted? yes or no ");
            System.out.println("1) Yes");
            System.out.println("0) No");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("You chose your bread to be toasted");
                    return true ;
                case "0":
                    System.out.println("You chose your bread to be not toasted");
                    return false;
                default:
                    System.out.println("Please provide valid number (1 or 0)");


            }

        }
    }
    //method to process checkout
    public void checkOut(){
        System.out.println("Your order summery: ");
        System.out.println(currentOrder.getOrderSummary());
        System.out.println("Total: $" + currentOrder.getTotalPrice());
        System.out.println("Thank you for your order");
        currentOrder= new Order(); //reset order after checkout
        mainMenu(); //return to main menu
    }
}





