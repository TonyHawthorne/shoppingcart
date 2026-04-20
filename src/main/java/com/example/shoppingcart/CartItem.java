package com.example.shoppingcart;

import java.math.BigDecimal;

public class CartItem {
    private String name;
    private BigDecimal price;
    private int quantity;

    public CartItem(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public BigDecimal getTotalPrice() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    @Override
    public String toString() {
        return name + " (Qty: " + quantity + ", Subtotal: £" + String.format("%.2f",getTotalPrice()) + ")";
    }
}