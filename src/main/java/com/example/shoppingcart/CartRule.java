package com.example.shoppingcart;

// Strategy interface: different things which share the same behavior (apply).
public interface CartRule {
    /**
     * A rule which can be applied to a shopping cart.
     * @param cart The shopping cart to evaluate.
     * @return String describing the execution result, e.g. rule applied or not.
     */
    String apply(ShoppingCart cart);
}
