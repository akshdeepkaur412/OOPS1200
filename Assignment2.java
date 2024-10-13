import java.util.Scanner;

public class Assignment2 {

    // Function to validate the number of days
    public static int getValidDays(Scanner input) {
        int numDays;
        while (true) {
            System.out.print("Enter the number of days to evaluate (2 to 366): ");
            numDays = input.nextInt();
            if (numDays >= 2 && numDays <= 366) {
                break;
            }
            System.out.println("Invalid entry. Please provide a number between 2 and 366.");
        }
        return numDays;
    }

    // Function to validate temperatures
    public static double getValidTemp(Scanner input, String tempDescription) {
        double temperature;
        while (true) {
            System.out.print("Enter the " + tempDescription + " temperature (-100 to 100): ");
            temperature = input.nextDouble();
            if (temperature >= -100 && temperature <= 100) {
                break;
            }
            System.out.println("Invalid entry. Temperature must be between -100 and 100.");
        }
        return temperature;
    }

    // Main function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Get the number of days
        int daysCount = getValidDays(input);

        // Arrays to store low and high temperatures
        double[] lowTemperatures = new double[daysCount];
        double[] highTemperatures = new double[daysCount];

        // Step 2: Gather temperatures for each day
        for (int i = 0; i < daysCount; i++) {
            System.out.println("Day " + (i + 1) + ":");
            while (true) {
                double lowTemp = getValidTemp(input, "low");
                double highTemp = getValidTemp(input, "high");
                
                // Ensure high temperature is greater than or equal to low
                if (highTemp >= lowTemp) {
                    lowTemperatures[i] = lowTemp;
                    highTemperatures[i] = highTemp;
                    break;
                }
                System.out.println("Error: High temperature must be greater than or equal to the low temperature.");
            }
        }

        // Step 3: Analyze temperatures
        double overallAvg = 0;
        double maxTemperature = Double.MIN_VALUE;
        double minTemperature = Double.MAX_VALUE;
        int hottestDay = 0, coldestDay = 0;

        System.out.println("\nTemperature Results:");
        for (int i = 0; i < daysCount; i++) {
            double avgTemp = (lowTemperatures[i] + highTemperatures[i]) / 2;
            System.out.printf("Day %d average temperature: %.2f\n", (i + 1), avgTemp);
            overallAvg += avgTemp;

            // Track hottest and coldest days
            if (highTemperatures[i] > maxTemperature) {
                maxTemperature = highTemperatures[i];
                hottestDay = i + 1;
            }
            if (lowTemperatures[i] < minTemperature) {
                minTemperature = lowTemperatures[i];
                coldestDay = i + 1;
            }
        }

        // Step 4: Display overall averages and results
        overallAvg /= daysCount;
        System.out.printf("\nOverall average temperature: %.2f\n", overallAvg);
        System.out.println("Day " + hottestDay + " had the highest temperature.");
        System.out.println("Day " + coldestDay + " had the lowest temperature.");
        
        input.close();
    }
}

