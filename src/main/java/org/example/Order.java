package org.example;

public class Order {
    private int totalPurchased;
    private int totalOrdered;
    private double averagePrice;
    private double averageProfit;

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * Returns average price at which object was purchased
     * @return double type number in case it is not divided wihout remainder
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * Returns current profit of the product
     * @return double type number in case it is not divided wihout remainder
     */
    public double getProfit() {
        return averageProfit * totalOrdered - averagePrice * totalOrdered;
    }

    /**
     * This method is used during the ordering of the product and this updates
     * current average profit of the product
     * @param quantity - integer number of how many products have been ordered
     * @param price - integer at which product has been ordered
     */
    public void updateOrderedPrice(int quantity, int price) {
        double newProfit = (totalOrdered * averageProfit + quantity * price) / (quantity + totalOrdered);
        averageProfit = newProfit;
        totalOrdered += quantity;
    }

    /**
     * This method is used during the purchasing of the product and updates average pruchased
     * price
     * @param quantity - quantity of how many producs has been purchased
     * @param price - integer number at which product was purchased
     */
    public void updatePurchasedPrice(int quantity, int price) {
        double newProfit = (totalPurchased * averagePrice + quantity * price) / (quantity + totalPurchased);
        averagePrice = newProfit;
        totalPurchased += quantity;
    }

    /**
     * This method returns total count of orders of the product
     * @return integer number of ordered products
     */
    public int getOrderCount() {
        return totalOrdered;
    }
}
