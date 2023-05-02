package org.example;

public class Product {
    private String productId;
    private String productName;
    private int quantity;
    private int price;

    /**
     * main constructor of this class sets passed arguments to intrance variables
     * @param productId - unique identifier of a product
     * @param productName - name of product object
     * @param price - current price which can be changed multiple times
     */
    public Product(String productId, String productName, int price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    /**
     * This method sets quantity and is used during first purchase of product
     * @param quantity - represents how many similar products are in balance
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * sets price for the product
     * @param price - represents current price of the product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Returns price of product object
     * @return integer which represents price of the product
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns quantity
     * @return integer number of this type of products in the store
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Returns name of the product instance
     * @return string name of product
     */
    public String getName() {
        return productName;
    }

    /**
     * Returns id of the product
     * @return string unique identifier
     */
    public String getId() {
        return productId;
    }

    /**
     * Decreases number of quantity of product. This method is used while ordering the product
     * Throws exception if delta is greater than quantity which means customer cannot order
     * this amount of products
     * @param delta - integer number of how many products have been ordered
     */
    public void decreaseQuantity(int delta) {
        if (quantity < delta) {
            throw new ArithmeticException("Quantity of product is not enough");
        }
        quantity -= delta;
    }

    /**
     * This method is used during purchasing this type of products
     * so after purchasing we should increase the quantity
     * @param delta - integer number of quantity of products purchased
     */
    public void increaseQuantity(int delta) {
        quantity += delta;
    }
}
