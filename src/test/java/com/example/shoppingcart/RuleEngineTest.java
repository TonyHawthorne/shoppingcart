package com.example.shoppingcart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class RuleEngineTest {
    private ShoppingCart cart;
    private RuleEngine ruleEngine;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        ruleEngine = new RuleEngine(cart);
    }

    @Test
    void applyRules_shouldHaveNoEffect_WhenRulesAreNotApplicable() {
        // Given
        ruleEngine.addRule(new BuyOneGetOneFreeRule("Banana"));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(5.0d), 2));

        // When
        ruleEngine.applyRules();

        // Then
        Assertions.assertEquals(1, cart.getItems().size());
        Assertions.assertEquals(0, BigDecimal.valueOf(10).compareTo(cart.getTotalCost()), "Cart total should not change when rules don't apply");
    }

    @Test
    void applyRules_buyOneGetOneFree_addsFreeItemsToCart() {
        // Given
        int paidQuantity = 3;
        ruleEngine.addRule(new BuyOneGetOneFreeRule("Apple"));

        // When
        cart.addItem(new CartItem("Apple", BigDecimal.valueOf(2.0), paidQuantity));
        ruleEngine.applyRules();

        CartItem freeItem = cart.getFreeCartItem("Apple");

        // Then
        Assertions.assertNotNull(freeItem, "Free items should have been added");
        Assertions.assertEquals(paidQuantity, freeItem.getQuantity(), "Buy one get one free should add one free item for every paid item");

    }

    @Test
    void applyRules_threeForThePriceOfTwo_reducesTotalCost() {
        // Given
        BigDecimal expectedTotal = BigDecimal.valueOf(0.50);

        // When
        ruleEngine.addRule(new ThreeForThePriceOfTwoRule("Orange"));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(0.25), 3));
        ruleEngine.applyRules();

        BigDecimal actualTotal = cart.getTotalCost();

        // Then
        Assertions.assertEquals(0, expectedTotal.compareTo(actualTotal),
                "Cart total should reduce by the price of one item when a 3 for 2 offer applies");

    }

}
