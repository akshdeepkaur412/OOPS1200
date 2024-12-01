// PerishableProducts.java
// Author: Akshdeep Kaur
// Date: November 30, 2024
// Description: Defines a PerishableProduct class inheriting from Product and main logic for product management.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PerishableProducts {
    // PerishableProduct class
    public static class PerishableProduct extends Product {
        private LocalDate expiryDate;

        // Default constructor
        public PerishableProduct() {
            super();
            this.expiryDate = LocalDate.now().plusDays(30); // Default expiry date is 30 days from now
        }

        // Parameterized constructor
        public PerishableProduct(String sku, String productName, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions, LocalDate expiryDate) {
            super(sku, productName, unitCost, salePrice, quantityOnHand, quantityNeeded, specialInstructions);
            setExpiryDate(expiryDate);
        }

        // Getter and setter for expiry date
        public LocalDate getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(LocalDate expiryDate) {
            if (expiryDate != null && expiryDate.isAfter(LocalDate.now())) {
                this.expiryDate = expiryDate;
            } else {
                throw new IllegalArgumentException("Expiry date must be in the future.");
            }
        }

        // Overridden display method
        @Override
        public String toString() {
            return super.toString() + "Expiry Date: " + expiryDate + "\n";
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("1) Create Product");
            System.out.println("2) Create Perishable Product");
            System.out.println("3) Display All Products");
            System.out.println("4) Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    // Create a standard product
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Unit Cost: ");
                    double unitCost = scanner.nextDouble();
                    System.out.print("Enter Sale Price: ");
                    double salePrice = scanner.nextDouble();
                    System.out.print("Enter Quantity on Hand: ");
                    int quantityOnHand = scanner.nextInt();
                    System.out.print("Enter Quantity Needed: ");
                    int quantityNeeded = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Special Instructions: ");
                    String instructions = scanner.nextLine();

                    products.add(new Product(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, instructions));
                }
                case 2 -> {
                    // Create a perishable product
                    System.out.print("Enter SKU: ");
                    String sku = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Unit Cost: ");
                    double unitCost = scanner.nextDouble();
                    System.out.print("Enter Sale Price: ");
                    double salePrice = scanner.nextDouble();
                    System.out.print("Enter Quantity on Hand: ");
                    int quantityOnHand = scanner.nextInt();
                    System.out.print("Enter Quantity Needed: ");
                    int quantityNeeded = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Special Instructions: ");
                    String instructions = scanner.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

                    products.add(new PerishableProduct(sku, name, unitCost, salePrice, quantityOnHand, quantityNeeded, instructions, expiryDate));
                }
                case 3 -> {
                    // Display all products
                    for (Product product : products) {
                        System.out.println(product);
                    }
                }
                case 4 -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
