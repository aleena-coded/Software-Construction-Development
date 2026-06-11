package Assign4;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items;
    private double discountPercentage;

    public ShoppingCart() {
        this.items = new HashMap<>();
        this.discountPercentage = 0.0;
    }

    public int addItem(String itemName, double price) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name should not be empty");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price should be greater than 0");
        }
        items.put(itemName, price);
        return items.size();
    }

    public boolean removeItem(String itemName) {
        if (items.containsKey(itemName)) {
            items.remove(itemName);
            return true;
        }
        return false;
    }

    public double calculateTotal() {
        double total = 0.0;
        for (double price : items.values()) {
            total += price;
        }
        return total - (total * (discountPercentage / 100));
    }

    public void applyDiscount(double percentage) {
        if (percentage > 50.0) {
            throw new IllegalArgumentException("Discount percentage cannot exceed 50%");
        }
        this.discountPercentage = percentage;
    }

    public String checkout(double paidAmount) {
        double total = calculateTotal();
        if (paidAmount >= total) {
            return "Payment Successful";
        } else {
            return "Insufficient Balance";
        }
    }
}

