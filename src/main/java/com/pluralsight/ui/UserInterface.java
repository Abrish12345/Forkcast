package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Drink;
import com.pluralsight.models.Order;
import com.pluralsight.models.Sandwich;
import com.pluralsight.util.ReceiptWriter;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; //import scanner to read user input

public class UserInterface {

    private Order currentOrder;  //new order ()

    Scanner scanner = new Scanner(System.in); //create a scanner instance for input

    //Display the main menu where the user can start a new order or exist
    public void mainMenu() {
        while (true) {

        System.out.println("1.\uD83C\uDD95 New Order");     //menu option one
        System.out.println("0.\uD83D\uDEAA Exit");         //menu option to exist
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
        currentOrder= new Order(); //reset order after checkout

        while (true){
        System.out.println("1.\uD83E\uDD6A Add Sandwich");      //option 1
        System.out.println("2.\uD83E\uDD64 Add Drink");        //option 2
        System.out.println("3.\uD83C\uDF5F Add Chips");       //option 3
        System.out.println("4.\uD83D\uDCB3  Checkout");       //option 4
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
                    extraMeat(sandwich);
                    cheese(sandwich);
                    extraCheese(sandwich);
                    sauces(sandwich);

                    //add the sandwich to the current order after finishing customization
                    currentOrder.addItem(sandwich);
                    System.out.println(sandwich);
                    System.out.println("Sandwich added to your order. ");


                    break;
                case "2":
                    System.out.println("Add Drink");            //Add drink options selected
                    String drinkSize = drinkSize();            //ask for size
                    if (drinkSize.equals("Exit")) break;
                    String drinkName = drinkName();           //ask for drink type
                    if (drinkName.equals("Exit")) break;
                    Drink drink = new Drink(drinkName, drinkSize);
                    currentOrder.addItem(drink);
                    System.out.println(drink.getDescription() + " added to your order. ");
                    break;
                case "3":
                    System.out.println("Add Chips");          //Add chips options selected
                    chips(currentOrder);
                    break;
                case "4":
                    checkOut();
                    System.out.println("Checkout");         //proceed to checkout
                    System.out.println(currentOrder.getOrderSummary());
                    System.out.println("Total: $" + String.format("%.2f", currentOrder.getTotalPrice()));

                    break;
                case "0":
                    System.out.println("Cancel Order");   //order is cancelled
                    currentOrder = new Order(); //CLEAR CURRENT ORDER IF WE WANT TO DISCARD
                    return;
                default:
                    System.out.println("please choose again"); //invalid input

            }
        }
    }

    //prompts the user to choose a type of bread and handles their selections
    public void breadType(Sandwich sandwich) {
        //Display bread options to the user
        while (true) {
            System.out.println("\uD83E\uDD56 What type of bread do you want?");
            System.out.println("1) \uD83C\uDF5E white");
            System.out.println("2) \uD83C\uDF3E wheat");
            System.out.println("3) \uD83C\uDF5E rye");
            System.out.println("4) \uD83C\uDF2F wrap");

            //Read the user's input
            String choice = scanner.nextLine();

            //check the user's input and print the selected bread type
            if (choice.equals("1")) {
                sandwich.setBreadType("white");
                System.out.println("you chose white bread");
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
            System.out.println("1) \uD83E\uDD6C Lettuce");
            System.out.println("2) \uD83E\uDED1 peppers");
            System.out.println("3) \uD83E\uDDC5 Onions");
            System.out.println("4) \uD83C\uDF45 Tomatoes");
            System.out.println("5) \uD83C\uDF36\uFE0F Jalapeños");
            System.out.println("6) \uD83E\uDD52 cucumbers");
            System.out.println("7) \uD83E\uDD52 pickles");
            System.out.println("8) \uD83E\uDD51 Guacamole");
            System.out.println("9) \uD83C\uDF44 Mushrooms");
            System.out.println("0) \uD83D\uDEAB None");

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



            askMultipleQuestion("\uD83E\uDD69 Please chose your meat topping? ", Arrays.asList("1\uFE0F⃣ Steak", " 2\uFE0F⃣ Ham", " 3\uFE0F⃣ Salami"," 4\uFE0F⃣ Roast Beef"," 5\uFE0F⃣ Chicken"," 6\uFE0F⃣ Bacon"," 0\uFE0F⃣ None"));

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
            System.out.println("2) \uD83E\uDDC0 provolone");
            System.out.println("3) \uD83E\uDDC0 cheddar");
            System.out.println("4) \uD83E\uDDC0 swiss");
            System.out.println("0) \uD83D\uDEAB None");

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
            System.out.println(" \uD83E\uDD6B Please chose your sauces topping? ");
            System.out.println("1) \uD83E\uDD44 Mayo");
            System.out.println("2) \uD83C\uDF2D Mustard");
            System.out.println("3) \uD83C\uDF45 Ketchup");
            System.out.println("4) \uD83E\uDD5B Ranch");
            System.out.println("5) \uD83E\uDD6D Thousand islands");
            System.out.println("0) \uD83D\uDEAB None");

            //read user input
            String sauceChoice = scanner.nextLine();

            if (sauceChoice.equals("0")) {
                System.out.println("No sauces added"); // if the user selects none
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

            }
            return;
        }
    }

    public String drinkSize() {
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
                    return "Small";
                case "2":
                    System.out.println("Medium drink added - $2.50");
                    return "Medium";
                case "3":
                    System.out.println("Large drink added - $3.00");
                    return "Large";
                case "0":
                    System.out.println("No drink added.");
                    return "Exit";
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input
                    break;
            }

        }

    }

    public String drinkName() {
        while (true) {
            System.out.println(" \uD83E\uDD64 Choose a drink:");
            System.out.println("1) \uD83E\uDD64 Coke");
            System.out.println("2) \uD83C\uDF4B Sprite");
            System.out.println("3) \uD83D\uDCA7 Water");
            System.out.println("4) \uD83C\uDF79 Iced Tea");
            System.out.println("0) ❌ Cancel");

            String drinkName = "";
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    return "Coke";

                case "2":
                    return "Sprite";

                case "3":
                    return "Water";

                case "4":
                    return "Iced Tea";

                case "0":
                    System.out.println("Drink selection cancelled. ");
                    return "Exit";
                default:
                    System.out.println("Invalid choice: " + choice);//handle invalid input
                    break;
            }
        }
    }

    public String chips(Order currentOrder) {
        while (true) {
            System.out.println(" \uD83C\uDF5F Choose a Chips:");
            System.out.println("1) \uD83C\uDF36\uFE0F Doritos");
            System.out.println("2) \uD83C\uDF3B SunChips");
            System.out.println("3) \uD83E\uDDC0 Cheetos");
            System.out.println("4) \uD83E\uDD54 Lays");
            System.out.println("5) \uD83E\uDDC2 Salt and Vinegar");
            System.out.println("0) ❌ Cancel");

            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                System.out.println("Chips selection cancelled. ");
                return "Exit";
            }
            String[] choices = choice.split(",");
            //loop through e ach selected choice
            for (String result : choices) {
                switch (result.trim()) { //remove extra spaces
                    case "1":
                        currentOrder.addItem(new Chips("Doritos"));
                        System.out.println("Doritos added to your order");
                        break;
                    case "2":
                        currentOrder.addItem(new Chips("SunChips"));
                        System.out.println("SunChips added to your order");
                        break;
                    case "3":
                        currentOrder.addItem(new Chips("Cheetos"));
                        System.out.println("Cheetos added to your order");
                        break;
                    case "4":
                        currentOrder.addItem(new Chips("Lays"));
                        System.out.println("Lays added to your order");
                        break;
                    case "5":
                        currentOrder.addItem(new Chips("Salt and Vinegar"));
                        System.out.println("Salt and Vinegar added to your order");
                        break;
                    default:
                        System.out.println("Invalid choice: " + result.trim());//handle invalid input
                        break;
                }

            }
            return "Chips added to order. ";
        }

    }

    public boolean toasted() {
        while (true) {
            System.out.println(" \uD83C\uDF5E Do you like your bread to be toasted? yes or no ");
            System.out.println("1) \uD83D\uDC4D Yes");
            System.out.println("0) \uD83D\uDC4E No");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("You chose your bread to be toasted");
                    return true;
                case "0":
                    System.out.println("You chose your bread to be not toasted");
                    return false;
                default:
                    System.out.println("Please provide valid number (1 or 0)");


            }

        }

    }
    //methods to add extra cheese

    public void extraCheese(Sandwich sandwich) {
        while (true) {
            System.out.println("Please chose your Extra cheese topping? ");
            System.out.println("1) american");
            System.out.println("2) provolone");
            System.out.println("3) cheddar");
            System.out.println("4) swiss");
            System.out.println("0) None");

            //read user input
            String choice = scanner.nextLine();

            if (choice.equals("0")) {
                System.out.println("No Extra cheese toppings added"); // if the user selects none
                return;

            }

            //split input by comma to handle multiple selections
            String[] choices = choice.split(",");

            //loop through each selected choice
            for (String meatChoice : choices) {
                switch (meatChoice.trim()) { //remove extra spaces
                    case "1":
                        sandwich.addExtraCheese("american");
                        System.out.println("Extra American cheese added");
                        break;
                    case "2":
                        sandwich.addExtraCheese("provolone");
                        System.out.println("Extra Provolone cheese added");
                        break;
                    case "3":
                        sandwich.addExtraCheese("cheddar");
                        System.out.println("Extra Cheddar cheese added");
                        break;
                    case "4":
                        sandwich.addExtraCheese("swiss");
                        System.out.println("Extra swiss cheese added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input

                        break;
                }

            }
            return;

        }
    }
   //method to add extra meat
    public void extraMeat(Sandwich sandwich){

        while (true) {
            System.out.println("Please chose your Extra  meat topping? ");
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
                System.out.println("No Extra meat toppings added"); // if the user selects none
                return;

            }

            //split input by comma to handle multiple selections
            String[] choices = choice.split(",");

            //loop through each selected choice
            for (String meatChoice : choices) {
                switch (meatChoice.trim()) { //remove extra spaces
                    case "1":
                        sandwich.addExtraMeat("Steak");
                        System.out.println("Extra Steak added");
                        break;
                    case "2":
                        sandwich.addExtraMeat("Ham");
                        System.out.println("Extra Ham added");
                        break;
                    case "3":
                        sandwich.addExtraMeat("Salami");
                        System.out.println("Extra Salami added");
                        break;
                    case "4":
                        sandwich.addExtraMeat("Roast Beef");
                        System.out.println("Extra Roast Beef added");
                        break;
                    case "5":
                        sandwich.addExtraMeat("Chicken");
                        System.out.println("Extra Chicken added");
                        break;
                    case "6":
                        sandwich.addExtraMeat("Bacon");
                        System.out.println("Extra Bacon added");
                        break;
                    default:
                        System.out.println("Invalid choice: " + choice);//handle invalid input

                        break;
                }

            }
            return;

        }

    }

    //method to process checkout
    public void checkOut(){

        System.out.println("\n============================== ");
        System.out.println("       \uD83D\uDED2 Your Order Summery \uD83D\uDED2 ");
        System.out.println("==============================");
        System.out.println(currentOrder.getOrderSummary());
        System.out.println("----------------------------- ");

        try{
            ReceiptWriter.saveReceipt(currentOrder);
            System.out.println("Receipt saved successfully!");
        }catch (IOException e){
            System.out.println("Error saving receipt: "+ e.getMessage());

        }


        System.out.println(" \uD83D\uDCB0 Total: $" + currentOrder.getTotalPrice());
        System.out.println(" \uD83D\uDE4F Thank you for your order!\n");

       // mainMenu(); //return to main menu

    }


    public void askMultipleQuestion( String prompt, List<String> options){
        System.out.println(prompt);
        for ( int i=0;  i < options.size(); i++){

         if (i== options.size() -1){
             System.out.println( "0) " + options.get(i));
         }else {
             System.out.println((i + 1) + ") " + options.get(i));
         }
        }
    }

}





