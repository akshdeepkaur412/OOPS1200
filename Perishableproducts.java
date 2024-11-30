// Perishableproducts.java
// Author: Akshdeep Kaur
// Date: 30-11-2024
// Description: A specialized class for items with expiration dates.

import java.time.LocalDate;

public class Perishableproducts extends Products {
    private LocalDate expirationDate;

    // Default Constructor
    public Perishableproducts () {
        super();
        this.expirationDate = LocalDate.now().plusDays(15); // Default expiry 15 days from now
    }

    // Parameterized Constructor
    public Perishableproducts (long identifier, String itemName, double costPrice, double retailPrice, int stockAvailable, int stockNeeded, String additionalNotes, LocalDate expirationDate) {
        super(identifier, itemName, costPrice, retailPrice, stockAvailable, stockNeeded, additionalNotes);
        this.expirationDate = expirationDate;
    }

    // Getter and Setter
    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    // Overridden Display Method
    @Override
    public String toString() {
        return super.toString() + "\nExpiration Date: " + expirationDate;
    }
}
