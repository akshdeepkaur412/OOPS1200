// App.java
// Author: Akshdeep Kaur
// Date: 30-11-2024
// Description: Application to manage items in inventory.

import java.util.*;

public class Main {
    private static final List<Products> itemList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1) Add Standard Item");
            System.out.println("2) Add Expiring Item");
            System.out.println("3) Update Item by ID");
            System.out.println("4) Remove Item by ID");
            System.out.println("5) View Item by ID");
            System.out.println("6) View All Items");
            System.out.println("7) Quit");
            System.out.print("Choose an option: ");
            userChoice = input.nextInt();

            switch (userChoice) {
                case 1 -> addStandardItem(input);
                case 2 -> addExpiringItem(input);
                case 3 -> updateItem(input);
                case 4 -> removeItem(input);
                case 5 -> viewItem(input);
                case 6 -> viewAllItems();
                case 7 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid input. Please try again.");
            }
        } while (userChoice != 7);
    }

    private static void addStandardItem(Scanner input) {
        // Functionality to add a standard item
    }

    private static void addExpiringItem(Scanner input) {
        // Functionality to add an expiring item
    }

    private static void updateItem(Scanner input) {
        // Functionality to update item by ID
    }

    private static void removeItem(Scanner input) {
        // Functionality to remove item by ID
    }

    private static void viewItem(Scanner input) {
        // Functionality to view item by ID
    }

    private static void viewAllItems() {
        // Functionality to view all items
    }
}
