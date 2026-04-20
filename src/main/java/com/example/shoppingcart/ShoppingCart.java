package com.example.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();
    private BigDecimal totalCost = BigDecimal.valueOf(0,2);

    public void addItem(CartItem cartItem) {
        this.items.add(cartItem);
        // Update the cart's total cost immediately
        this.totalCost = this.totalCost.add(cartItem.getTotalPrice());
        System.out.println("Added: " + cartItem.getQuantity() + " x " + cartItem.getName());
    }

    public List<CartItem> getItems() {
        return items;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void checkout() {
        System.out.println();
        System.out.println("Shopping Cart:");
        System.out.println("=======================================");
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            items.forEach(System.out::println);
        }
        System.out.println("---------------------------------------");
        System.out.println("Total: £" + totalCost);
        System.out.println("=======================================");
    }
}