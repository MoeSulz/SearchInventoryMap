package com.learntocode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class StoreApp {
    static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();

    



    public static void main(String[] args) {
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
            return;
        }else{
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
        }

    }
    public static void loadInventory(){
        String filename = "Inventory.csv";
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                float price = Float.parseFloat(tokens[2]);
                inventory.put(id, new Product(id, name, price));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }

}
