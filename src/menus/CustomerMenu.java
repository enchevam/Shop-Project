package menus;

import customer.Customer;
import products.Product;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static products.ProductActions.*;
import static utility.Queries.QUERY_PRINT_PRODUCTS_BY_CUSTOMER;
import static utility.Queries.QUERY_SEARCH_PRODUCTS;
import static utility.UtilMethods.*;

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

            checkInt(sc, "Enter correct choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {

                    ArrayList<Product> products = printProducts(statement, QUERY_PRINT_PRODUCTS_BY_CUSTOMER);
                    printProductArrayList(products);
                }
                case 2 -> {
                    System.out.print("Enter product type: ");
                    sc.nextLine();
                    String type = sc.nextLine();
                    checkString(type, sc);
                    String query = QUERY_SEARCH_PRODUCTS + type + "%'";
                    ArrayList<Product> products = searchProducts(statement, query);
                    printProductArrayList(products);
                    System.exit(0);
                }
                case 3 -> {
                    System.out.print("Enter product name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    checkString(name, sc);
                    String query = QUERY_SEARCH_PRODUCTS + name + "%'";
                    ArrayList<Product> products = searchProducts(statement, query);
                    printProductArrayList(products);
                    System.exit(0);
                }
                case 4 -> {
                    System.out.print("Enter product id: ");

                    checkInt(sc, "Enter valid product id");

                    int id = sc.nextInt();
                    int quantity;
                    Product product;
                    do {
                        System.out.print("Enter product quantity: ");
                        checkInt(sc, "Enter valid data");
                        quantity = sc.nextInt();
                        product = searchProductsById(statement, id, quantity);
                    } while (product == null);
                    customer.addToCart(product);
                    subtractQuantity(statement, quantity, id);
                    System.out.println(customer);
                }
                case 5 -> System.out.println("Your total is: " + customer.calculateTotalSum());
                default -> System.out.println("Invalid choice! Try again!\n");
            }
        } while (true);
    }
}
