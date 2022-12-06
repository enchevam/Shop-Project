package menus;

import customer.Customer;
import products.Product;

import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import static customer.CustomerActions.buyProduct;
import static menus.MainMenu.showMainMenu;
import static products.ProductActions.printProducts;
import static products.ProductActions.searchProducts;
import static utility.Queries.*;
import static utility.UtilMethods.*;

public class CustomerMenu {

    public static void printCustomerMenu() {

        System.out.println("\n==================== Customer Menu ===================");
        System.out.println("[1] Print all products (with at least 1 in stock)");
        System.out.println("[2] Search product by category");
        System.out.println("[3] Search product by name");
        System.out.println("[4] Add product to cart");
        System.out.println("[5] Print total sum");
        System.out.println("[6] Return to Main Menu");
        System.out.println("[7] Exit");
        System.out.println("=====================================================");
        System.out.print("Your choice: ");
    }

    public static void showCustomerMenu(Scanner sc, Statement statement, Customer customer) {
        int choice;
        Timestamp showTime =new Timestamp(System.currentTimeMillis());
        do {
            printCustomerMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    ArrayList<Product> products = printProducts(statement,QUERY_PRINT_PRODUCTS_BY_CUSTOMER);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                }
                case 2 -> {
                    System.out.print("Enter product type: ");
                    sc.nextLine();
                    String type = sc.nextLine();
                    checkString(type, sc);
                    String query = QUERY_SEARCH_PRODUCTS_BY_TYPE + type + "%'";
                    ArrayList<Product> products = searchProducts(statement, query);
                    printProductArrayList(products);
                }
                case 3 -> {
                    System.out.print("Enter product name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    checkString(name, sc);
                    String query = QUERY_SEARCH_PRODUCTS_BY_NAME + name + "%'";
                    ArrayList<Product> products = searchProducts(statement, query);
                    printProductArrayList(products);
                }
                case 4 -> {
                    int id;
                    do {
                    System.out.print("Enter product id: ");
                    id = sc.nextInt();
                    } while (!checkIdExists(statement, id));
                    buyProduct(sc, statement, customer, id);

                }
                case 5 -> System.out.println("Your total is: " + customer.calculateTotalSum()+" at: "+showTime);
                case 6 -> showMainMenu(sc,statement, null);
                case 7 -> System.exit(0);

                default -> System.out.println("Invalid choice! Try again!\n");
            }
        } while (true);
    }
}