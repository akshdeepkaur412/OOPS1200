// Product.java
// Author: Akshdeep Kaur
// Date: November 30, 2024
// Description: Defines a base Product class with properties and methods.

public class Product {
    private String sku;
    private String productName;
    private double unitCost;
    private double salePrice;
    private int quantityOnHand;
    private int quantityNeeded;
    private String specialInstructions;

    // Default constructor
    public Product() {
        this.sku = "00000000";
        this.productName = "Default Product";
        this.unitCost = 0.0;
        this.salePrice = 0.0;
        this.quantityOnHand = 0;
        this.quantityNeeded = 0;
        this.specialInstructions = "None";
    }

    // Parameterized constructor
    public Product(String sku, String productName, double unitCost, double salePrice, int quantityOnHand, int quantityNeeded, String specialInstructions) {
        setSku(sku);
        setProductName(productName);
        setUnitCost(unitCost);
        setSalePrice(salePrice);
        setQuantityOnHand(quantityOnHand);
        setQuantityNeeded(quantityNeeded);
        this.specialInstructions = specialInstructions;
    }

    // Getters and setters with validation
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        if (sku != null && sku.matches("\\d{8,}")) {
            this.sku = sku;
        } else {
            throw new IllegalArgumentException("SKU must be 8 or more digits.");
        }
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName != null && !productName.trim().isEmpty()) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Product name cannot be blank.");
        }
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        if (unitCost >= 0) {
            this.unitCost = unitCost;
        } else {
            throw new IllegalArgumentException("Unit cost must be >= 0.");
        }
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        if (salePrice >= 0) {
            this.salePrice = salePrice;
        } else {
            throw new IllegalArgumentException("Sale price must be >= 0.");
        }
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand >= 0) {
            this.quantityOnHand = quantityOnHand;
        } else {
            throw new IllegalArgumentException("Quantity on hand must be >= 0.");
        }
    }

    public int getQuantityNeeded() {
        return quantityNeeded;
    }

    public void setQuantityNeeded(int quantityNeeded) {
        if (quantityNeeded >= 0) {
            this.quantityNeeded = quantityNeeded;
        } else {
            throw new IllegalArgumentException("Quantity needed must be >= 0.");
        }
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    // Display method
    @Override
    public String toString() {
        return "SKU: " + sku + "\n" +
               "Product Name: " + productName + "\n" +
               "Unit Cost: $" + unitCost + "\n" +
               "Sale Price: $" + salePrice + "\n" +
               "Quantity on Hand: " + quantityOnHand + "\n" +
               "Quantity Needed: " + quantityNeeded + "\n" +
               "Special Instructions: " + specialInstructions + "\n";
    }
}
