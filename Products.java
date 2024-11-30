// Products.java
// Author: Akshdeep Kaur
// Date: 30-11-2024
// Description: A class to represent a general item in inventory.

public class Products {
    private long identifier;
    private String itemName;
    private double costPrice;
    private double retailPrice;
    private int stockAvailable;
    private int stockNeeded;
    private String additionalNotes;

    // Default Constructor
    public Products() {
        this.identifier = 10000000L;
        this.itemName = "Sample Item";
        this.costPrice = 0.0;
        this.retailPrice = 0.0;
        this.stockAvailable = 0;
        this.stockNeeded = 0;
        this.additionalNotes = "None";
    }

    // Parameterized Constructor
    public Products (long identifier, String itemName, double costPrice, double retailPrice, int stockAvailable, int stockNeeded, String additionalNotes) {
        setIdentifier(identifier);
        setItemName(itemName);
        setCostPrice(costPrice);
        setRetailPrice(retailPrice);
        setStockAvailable(stockAvailable);
        setStockNeeded(stockNeeded);
        this.additionalNotes = additionalNotes;
    }

    // Accessors and Mutators with Validation
    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        if (String.valueOf(identifier).length() >= 8) {
            this.identifier = identifier;
        } else {
            throw new IllegalArgumentException("Identifier must have at least 8 digits.");
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        if (itemName != null && !itemName.isBlank()) {
            this.itemName = itemName;
        } else {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        if (costPrice >= 0) {
            this.costPrice = costPrice;
        } else {
            throw new IllegalArgumentException("Cost price must not be negative.");
        }
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        if (retailPrice >= 0) {
            this.retailPrice = retailPrice;
        } else {
            throw new IllegalArgumentException("Retail price must not be negative.");
        }
    }

    public int getStockAvailable() {
        return stockAvailable;
    }

    public void setStockAvailable(int stockAvailable) {
        if (stockAvailable >= 0) {
            this.stockAvailable = stockAvailable;
        } else {
            throw new IllegalArgumentException("Stock available must not be negative.");
        }
    }

    public int getStockNeeded() {
        return stockNeeded;
    }

    public void setStockNeeded(int stockNeeded) {
        if (stockNeeded >= 0) {
            this.stockNeeded = stockNeeded;
        } else {
            throw new IllegalArgumentException("Stock needed must not be negative.");
        }
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    // Display Method
    @Override
    public String toString() {
        return "Identifier: " + identifier +
                "\nItem Name: " + itemName +
                "\nCost Price: $" + costPrice +
                "\nRetail Price: $" + retailPrice +
                "\nStock Available: " + stockAvailable +
                "\nStock Needed: " + stockNeeded +
                "\nAdditional Notes: " + additionalNotes;
    }
}
