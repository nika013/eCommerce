package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Catalog catalog = new Catalog();

        while(!command.equals("exit")) {
            String[] tokens = command.split(" ");
            makeOperation(catalog, tokens);
            command = scanner.nextLine();
        }

    }

    private static void makeOperation(Catalog catalog, String[] tokens) {
        String operation = tokens[0];
        if (operation.equals("save_product")) {
            catalog.saveProduct(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
        } else if (operation.equals("purchase_product")) {
            catalog.purchaseProduct(tokens[1], Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
        } else if (operation.equals("order_product")) {
            catalog.orderProduct(tokens[1], Integer.parseInt(tokens[2]));
        } else if (operation.equals("get_quantity_of_product")) {
            System.out.println(catalog.getQuantity(tokens[1]));
        } else if (operation.equals("get_average_price")) {
            System.out.println((int) catalog.getAveragePrice(tokens[1]));
        } else if (operation.equals("get_product_profit")) {
            System.out.println((int) catalog.getProductProfit(tokens[1]));
        } else if (operation.equals("get_fewest_product")) {
            System.out.println(catalog.getFewestProduct());
        } else if (operation.equals("get_most_popular_product")) {
            System.out.println(catalog.getPopular());
        } else {
            System.out.println("Command: " + operation + " is not Valid!");
        }
    }
}