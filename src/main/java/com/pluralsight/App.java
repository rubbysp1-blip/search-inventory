package com.pluralsight;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        inventory.add(new Product(12, "Screws", 12.00));
        inventory.add(new Product(12, "Hammer", 12.00));
        inventory.add( new Product(12, "Tape", 12.00));
        inventory.add( new Product(12, "Rope", 12.00));
        inventory.add( new Product(12, "Light Bulbs", 12.00));


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
