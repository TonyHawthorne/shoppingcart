package com.example.shoppingcart;

import java.math.BigDecimal;

public class BuyOneGetOneFreeRule implements CartRule {
    String itemName;

    public BuyOneGetOneFreeRule(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String apply(ShoppingCart cart) {
        for (CartItem item : cart.getItems()) {

            // If we match the item by name AND it's not a free item we added earlier
            if (itemName.equals(item.getName()) &&
                    BigDecimal.ZERO.compareTo(item.getPrice()) < 0) {
                // Add one free item for every paid item.
                cart.addItem(new CartItem(itemName, BigDecimal.ZERO, item.getQuantity()));
                return "Buy one get one free added " + item.getQuantity() + " free " + itemName + "(s)";
            }
        }
        return "Buy one get one free check complete";
    }
}
