package com.example.shoppingcart;

import java.util.ArrayList;
import java.util.List;

// RuleEngine executes rules against the cart (in the order they were added)
class RuleEngine {
    private final ShoppingCart cart;
    private final List<CartRule> rules = new ArrayList<>();

    public RuleEngine(ShoppingCart cart) {
        this.cart = cart;
    }

    public void addRule(CartRule rule) {
        this.rules.add(rule);
    }

    /**
     * Executes the specified rules against the cart.
     */
    public void applyRules() {
        System.out.println("Applying cart rules...");
        for (CartRule rule : rules) {
            System.out.println("Evaluating rule: " + rule.getClass().getSimpleName());
            String result = rule.apply(cart);
            System.out.println("-> Result: " + result);
        }
        System.out.println("Finished applying cart rules");
    }

    public ShoppingCart getCart() {
        return cart;
    }
}