package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();

        enterInventoryToList(inventory);

        printInventory(inventory);
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

        } catch (IOException e) {
            System.out.print("File not found please check file name or direction.");
        }
    }

    private static void sortListByName(ArrayList<Product> inventory) {
        Collections.sort(inventory, Comparator.comparing(Product::getName));
    }

    private static void printInventory(ArrayList<Product> inventory) {
        System.out.println("We carry the following inventory: ");
        for (int i = 0; i < inventory.size(); i++) {
            Product p = inventory.get(i);

            System.out.printf("id: %d %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());

        }
    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();
        // this method loads product objects into inventory
        // and its details are not shown
        return inventory;
    }
}
