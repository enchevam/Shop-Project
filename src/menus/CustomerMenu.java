package menus;

import customer.Customer;
import products.Product;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static products.ProductActions.*;

public class CustomerMenu {

    public static void printCustomerMenu() {

        System.out.println("Choose action:");
        System.out.println("1. Print all products (with at least 1 in stock)");
        System.out.println("2. Search product by category");
        System.out.println("3. Search product by name");
        System.out.println("4. Add product to cart");
        System.out.println("5. Print total sum");
    }

    public static void showCustomerMenu(Scanner sc, Statement statement, Customer customer) {
        int choice;

        do {
            printCustomerMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    ArrayList<Product> products = printAllProductsByCustomer(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 2 -> {
                    System.out.print("Enter product type: ");
                    sc.nextLine();
                    String type = sc.nextLine();
                    ArrayList<Product> products = searchProductsByCategory(statement, type);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 3 -> {
                    System.out.print("Enter product name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    ArrayList<Product> products = searchProductsByName(statement, name);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 4 -> {
                    System.out.print("Enter product id: ");
                    int id = sc.nextInt();
                    Product product;
                    do {
                        System.out.print("Enter product quantity: ");
                        int quantity = sc.nextInt();
                        product = searchProductsById(statement, id, quantity);
                    } while (product == null);
                    customer.addToCart(product);
                    System.out.println(customer);
                }
                case 5 -> System.out.println("Your total is: " + customer.calculateTotalSum());
                default -> System.out.println("Invalid choice! Try again!\n");
            }
        } while (true);
    }
}
