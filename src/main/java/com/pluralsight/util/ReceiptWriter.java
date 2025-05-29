package com.pluralsight.util;

import com.pluralsight.models.Order;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceiptWriter {
    public static void saveReceipt(Order order) throws IOException {
        //CREATE FOLDER IF IT DOESNT EXIST
        File folder = new File("receipts");
        if (!folder.exists()) {
            folder.mkdir();
        }
        //create file name with current date and time
        String filename = "receipts/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(order.getOrderSummary());
            writer.newLine();
            writer.newLine();
            writer.write("Total Price: $" + String.format("%.2f", order.getTotalPrice()));
            writer.newLine();
            writer.write("Thanks for your order");


        }

    }
}

        /*
        //create file name with current date and time
        String filename = "receipts/" + new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";

        //write order details to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(order.getOrderSummary());
        writer.newLine();
        writer.write("Total Price: $" + String.format("%.2f", order.getTotalPrice() ));
        writer.close();


    }
*/


