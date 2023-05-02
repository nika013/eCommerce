package org.example;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class Tests extends TestCase {
    @Test
    public void testProduct() {
        Product prod01 = new Product("prod001", "iphone", 2800);
        assertTrue("prod001".equals(prod01.getId()));
        assertTrue("iphone".equals(prod01.getName()));
        assertEquals(2800, prod01.getPrice());
        prod01.setQuantity(10);
        assertEquals(10, prod01.getQuantity());
        prod01.decreaseQuantity(3);
        assertEquals(7, prod01.getQuantity());
        prod01.setPrice(3500);
        assertEquals(3500, prod01.getPrice());
        prod01.increaseQuantity(10);
        assertEquals(17, prod01.getQuantity());
    }

    @Test
    public void testSaveProduct() {
        Catalog catalog = new Catalog();
        catalog.saveProduct("prod001", "iphone", 2800);
        catalog.saveProduct("prod001", "iphone", 3500);
    }

    @Test
    public void testPurchaseProducts() {
        Catalog catalog = new Catalog();
        catalog.saveProduct("prod001", "iphone", 2800);
        catalog.purchaseProduct("prod001", 10, 2400);
        assertEquals(10, catalog.getQuantity("prod001"));
        assertEquals(2400, (int) catalog.getAveragePrice("prod001"));

        catalog.saveProduct("prod002", "samsung", 3100);
        catalog.purchaseProduct("prod002", 10, 2000);
        assertEquals(2000, (int) catalog.getAveragePrice("prod002"));
        catalog.purchaseProduct("prod002", 30, 3000);
        assertEquals(2750, (int) catalog.getAveragePrice("prod002"));
        assertEquals(40, catalog.getQuantity("prod002"));

        catalog.saveProduct("prod002", "samsung", 3500);
        assertEquals(40, catalog.getQuantity("prod002"));
        catalog.orderProduct("prod002", 5);
        catalog.saveProduct("prod002", "samsung", 3800);
        catalog.orderProduct("prod002", 10);
        catalog.saveProduct("prod002", "samsung", 4000);
        catalog.orderProduct("prod002", 15);
        assertEquals(2750, (int) catalog.getAveragePrice("prod002"));
        assertEquals(33000, (int) catalog.getProductProfit("prod002"));
    }

    @Test
    public void testFewestAndMost() {
        Catalog catalog = new Catalog();
        catalog.saveProduct("1", "iphone", 3300);
        catalog.saveProduct("2", "samsung", 2800);

        catalog.purchaseProduct("1", 10, 2500);
        catalog.purchaseProduct("2", 20, 1800);

        assertTrue(catalog.getFewestProduct().equals("iphone"));
        catalog.orderProduct("2", 5);
        assertTrue(catalog.getPopular().equals("samsung"));
        catalog.orderProduct("1", 8);
        assertTrue(catalog.getPopular().equals("iphone"));
        assertTrue(catalog.getFewestProduct().equals("iphone"));

        catalog.saveProduct("3", "xiaomi", 1700);
        catalog.purchaseProduct("3", 30, 1100);
        catalog.orderProduct("3", 26);
        assertTrue(catalog.getFewestProduct().equals("iphone"));
        assertTrue(catalog.getPopular().equals("xiaomi"));

    }
}
