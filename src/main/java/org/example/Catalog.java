package org.example;

import java.util.HashMap;

public class Catalog {
    private HashMap<String, Product> store;
    private HashMap<String, Order> orders;
    private String fewestProduct;
    private int fewestQuantity = Integer.MAX_VALUE;
    private String mostPopular;
    private int mostOrdered = Integer.MIN_VALUE;

    /**
     * Main constructor
     */
    public Catalog() {
        store = new HashMap<>();
        orders = new HashMap<>();
    }

    /**
     * This methods adds new product to the store and saves it. Here is created new product
     * object which is saved in hashmap
     * @param productId - unique identifier for product object
     * @param productName - name of the product
     * @param price - current price of the product
     */
    public void saveProduct(String productId, String productName, int price) {
        if (!store.containsKey(productId)) {
            Product newProd = new Product(productId, productName, price);
            store.put(productId, newProd);
            orders.put(productId, new Order());
        } else {
            Product prod = store.get(productId);
            prod.setPrice(price);
        }
    }

    /**
     * This method defines logic of purchasing certain product at given price for the store
     * If the product is not saved earlier it cannot be purchased
     * @param productId - unique identifier for product object
     * @param quantity - integer of how many instances of this product have been purchased
     * @param price - integer number at which product has been purchased
     */
    public void purchaseProduct(String productId, int quantity, int price) {
        if (store.containsKey(productId)) {
            Product product = store.get(productId);
            product.increaseQuantity(quantity);
            Order order = orders.get(productId);
            order.updatePurchasedPrice(quantity, price);
            updateFewest(product);
        } else {
            System.out.println("Product with the id: " + productId + " does not exist");
        }
    }

    /**
     * Defines logic of ordering the product
     * @param productId - unique identifier for product object
     * @param quantity - integer number of how many products consumer has oredered
     */
    public void orderProduct(String productId, int quantity) {
        if (store.containsKey(productId)) {
            Product product = store.get(productId);
            product.decreaseQuantity(quantity);
            Order order = orders.get(productId);
            order.updateOrderedPrice(quantity, product.getPrice());
            updateMostOrdered(product, order);
        }
    }

    /**
     * udpates fewest product
     * @param product - Product type object
     */
    private void updateFewest(Product product) {
        int currentQuantity = product.getQuantity();
        if (currentQuantity < fewestQuantity) {
            fewestQuantity = currentQuantity;
            fewestProduct = product.getName();
        }
    }

    /**
     * updates which product is the most ordered
     * @param product - Product type object
     * @param order - HashMap of history orders of passed product object
     */
    private void updateMostOrdered(Product product, Order order) {
        int currentOrdered = order.getOrderCount();
        if (currentOrdered > mostOrdered) {
            mostOrdered = currentOrdered;
            mostPopular = product.getName();
        }
    }

    /**
     * Returns current euqntity of the product
     * @param productId - unique identifier for product object
     * @return integer quantity of the product
     */
    public int getQuantity(String productId) {
        return store.get(productId).getQuantity();
    }

    /**
     * Returns average price at which object was purchased
     * @param productId - string unique identifier of the object
     * @return double type number in case it is not divided wihout remainder
     */
    public double getAveragePrice(String productId) {
        return orders.get(productId).getAveragePrice();
    }

    /**
     * Returns current profit of the product
     * @param productId - string unique identifier of the object
     * @return double type number in case it is not divided wihout remainder
     */
    public double getProductProfit(String productId) {
        return orders.get(productId).getProfit();
    }

    /**
     * Returns name of the fewest quantity product
     * @return string name of the product
     */
    public String getFewestProduct() {
        return fewestProduct;
    }

    /**
     * Returns name of the most ordered product
     * @return string name of the product
     */
    public String getPopular() {
        return mostPopular;
    }
}
