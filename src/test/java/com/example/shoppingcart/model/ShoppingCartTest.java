package com.example.shoppingcart.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void initialCartIsEmpty() {
        // Given: a new cart

        // When
        List<CartItem> cartItems = cart.getItems();

        // Then
        assertTrue(cartItems.isEmpty());
    }

    @Test
    void initialCartTotalCostIsZero() {
        // Given: a new cart

        // When
        BigDecimal totalCost = cart.getTotalCost();

        // Then
        assertEquals(0, totalCost.compareTo(BigDecimal.ZERO), "Total price should be zero for an empty cart");
    }

    @Test
    void shouldAddItemsToCart() {
        // Given: a new cart

        // When
        cart.addItem(new CartItem("Apple", BigDecimal.valueOf(1.00), 1));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(2.01), 3));

        // Then
        assertNotNull(cart.getItems());
        assertEquals(2, cart.getItems().size());

        assertEquals("Apple", cart.getItems().getFirst().getName());
        assertEquals(BigDecimal.valueOf(1.00), cart.getItems().getFirst().getPrice());
        assertEquals(1, cart.getItems().getFirst().getQuantity());

        assertEquals("Orange", cart.getItems().get(1).getName());
        assertEquals(BigDecimal.valueOf(2.01), cart.getItems().get(1).getPrice());
        assertEquals(3, cart.getItems().get(1).getQuantity());
    }

    @Test
    void shouldCalculateTotalPriceForOneCartItem() {
        // Given a new cart
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(5.05), 1));

        // When
        BigDecimal totalCost = cart.getTotalCost();

        // Then
        Assertions.assertEquals(BigDecimal.valueOf(5.05), totalCost, "Total price should be equal to price * quantity");
    }

    @Test
    void shouldCalculateTotalPriceAsSumOfQuantityTimesPriceForAllItems() {
        // Given a new cart

        // When Adding 3 Apples (0.60 each) and 1 Orange (0.25 each)
        cart.addItem(new CartItem("Apples", BigDecimal.valueOf(0.60), 3));
        cart.addItem(new CartItem("Orange", BigDecimal.valueOf(0.25), 1));
        BigDecimal totalCost = cart.getTotalCost();

        // Then Total should be (3 x 0.60) + (1 x 0.25) = 2.05
        Assertions.assertEquals(BigDecimal.valueOf(2.05), totalCost, "Total price should equal sum(price * quantity) for all items");
    }
}