package Assign4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;


public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    // --- Test Cases for addItem() ---

    @Test
    public void testAddItem_Valid() {
        // Positive: Adding a valid item returns the new item count (1)
        assertEquals(1, cart.addItem("Laptop", 50000));
    }

    @Test
    public void testAddItem_Invalid() {
        assertThrows(
            IllegalArgumentException.class,
            () -> cart.addItem("", 50000)
        );
    }

    // --- Test Cases for removeItem() ---

    @Test
    public void testRemoveItem_Valid() {
        cart.addItem("Laptop", 50000);
        // Positive: Successfully removing an existing item returns true
        assertTrue(cart.removeItem("Laptop"));
    }

    @Test
    public void testRemoveItem_Invalid() {
        cart.addItem("Laptop", 50000);
        // Negative: Trying to remove an item not in the cart returns false
        assertFalse(cart.removeItem("Smartphone"));
    }

   

    // --- Test Cases for checkout() ---

    @Test
    public void testCheckout_Valid() {
        cart.addItem("Laptop", 50000);

        assertEquals(
            "Payment Successful",
            cart.checkout(60000)
        );
    }

    @Test
    public void testCheckout_Invalid() {
        cart.addItem("Laptop", 50000);

        assertEquals(
            "Insufficient Balance",
            cart.checkout(10000)
        );
    }
}
