import java.util.Scanner;

public class Assignment1 {
    // Declare constants for min and max pizza size
    final static int MIN_DIAMETER = 6;
    final static int MAX_DIAMETER = 24;

    public static void main(String[] args) {
        // Name: Akshdeep Kaur
        // Date: 27-09-2024
        // Description: This program calculates the number of pizza slices based on pizza size (diameter).

        Scanner scanner = new Scanner(System.in);
        double diameter;

        // Ask the user for the pizza size 
        do {
            System.out.print("Please enter the size of your pizza (diameter in inches): ");
            diameter = scanner.nextDouble();

            // Validate if the diameter 
            if (diameter < MIN_DIAMETER || diameter > MAX_DIAMETER) {
                System.out.println("Your pizza size must be between " + MIN_DIAMETER + " and " + MAX_DIAMETER + " inches.");
            }
        } while (diameter < MIN_DIAMETER || diameter > MAX_DIAMETER);

        int pizzaSlices;
        
        // Decide the number of slices based on pizza size
        if (diameter < 8) {
            pizzaSlices = 4;
        } else if (diameter < 12) {
            pizzaSlices = 6;
        } else if (diameter < 14) {
            pizzaSlices = 8;
        } else if (diameter < 16) {
            pizzaSlices = 10;
        } else if (diameter < 20) {
            pizzaSlices = 12;
        } else {
            pizzaSlices = 16;
        }

        // Calculate the area of the pizza 
        
        double radius = diameter / 2;
        double area = Math.PI * Math.pow(radius, 2);
        double areaPerSlice = area / pizzaSlices;

        // Show the user the results
        System.out.printf("A %.1f-inch pizza will give you %d slices.\n", diameter, pizzaSlices);
        System.out.printf("Each slice will be about %.2f square inches.\n", areaPerSlice);
    }
}
