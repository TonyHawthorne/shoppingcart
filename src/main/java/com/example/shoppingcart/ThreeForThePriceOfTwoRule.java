package com.example.shoppingcart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ThreeForThePriceOfTwoRule implements CartRule {
    String itemName;

    public ThreeForThePriceOfTwoRule(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String apply(ShoppingCart cart) {
        List<CartItem> freeItemList = new ArrayList<>();
        String msg = "Three for the price of two check complete";

        for (CartItem item : cart.getItems()) {
            // If we find a matching item
            // and quantity is >= 3
            // and the matched item is not a free item
            if (itemName.equals(item.getName())
                    && (item.getQuantity() >= 3)
                    && BigDecimal.ZERO.compareTo(item.getPrice()) < 0) {

                // Calculate the number of free items applicable
                int freeItems = item.getQuantity() / 3;

                // 1. Reduce the paid cart item count by that number
                item.setQuantity(item.getQuantity() - freeItems);

                // 2. Adjust (Reduce) the cart's total price to match
                cart.adjustTotalCost(BigDecimal.ZERO.subtract(item.getPrice().multiply(BigDecimal.valueOf(freeItems))));

                // 3. Build a list of free items to be added
                freeItemList.add(new CartItem(item.getName(), BigDecimal.ZERO, freeItems));

                msg = "Three for the price of two made " + freeItems + " " + itemName + "(s) free";
            }
        }
        // Add the free cart items
        cart.getItems().addAll(freeItemList);
        return msg;
    }
}
