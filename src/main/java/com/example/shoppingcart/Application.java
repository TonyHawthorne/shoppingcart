package com.example.shoppingcart;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new CartItem("Apple", BigDecimal.valueOf(0.60), 3));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(0.25), 1));

        cart.checkout();
    }
}