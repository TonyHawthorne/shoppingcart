package com.example.shoppingcart;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new CartItem("Apple", BigDecimal.valueOf(0.60), 3));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(0.25), 1));

        // Add ruleEngine and register rules
        RuleEngine ruleEngine = new RuleEngine(cart);
        ruleEngine.addRule(new ThreeForThePriceOfTwoRule("Orange"));
        ruleEngine.addRule(new BuyOneGetOneFreeRule("Apple"));

        ruleEngine.applyRules();

        cart.checkout();
    }
}