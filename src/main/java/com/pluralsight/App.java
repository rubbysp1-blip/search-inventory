package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Product> inventory = getInventory();

        enterInventoryToList(inventory);


        int menuDecision = 0;
        System.out.println("-----------------------------");
        while (menuDecision != 5) {
            System.out.println("What would you like to do: ");
            menuDecision = input.nextInt();

            switch (menuDecision) {
                case 1 -> System.out.println("Listing all the products:");
                case 2 -> System.out.println("Looking up the product by its ID:");
                case 3 -> System.out.println("Finding all products within price range:");
                case 4 -> System.out.println("Adding new product..");
                case 5 -> System.out.println("Quit application");
                default -> System.out.println("Invalid input.");
            }
        }
    }

    private static void enterInventoryToList(ArrayList<Product> inventory) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));
            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] products = line.split("\\|");
                inventory.add(new Product(Integer.parseInt(products[0]), products[1], Double.parseDouble(products[2])));
            }
            sortListByName(inventory);
            printInventory(inventory);

        } catch (IOException e) {
            System.out.print("ERROR: File not found please check file name or direction.");
        }
    }

    private static void sortListByName(ArrayList<Product> inventory) {
        inventory.sort(Comparator.comparing(Product::getName));
    }

    private static void printInventory(ArrayList<Product> inventory) {
        System.out.println("""
                We carry the following inventory:\s
                ---------------------------------""");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);
            System.out.println(p.toPriceFormat());
        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory
        // and its details are not shown
        return inventory;
    }
}
