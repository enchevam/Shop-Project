package menus;

import employee.Employee;
import products.Product;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

import static employee.EmployeeActions.sortEmployees;
import static menus.MainMenu.showMainMenu;
import static products.ProductActions.*;
import static utility.Queries.*;
import static utility.UtilMethods.printEmployeeArrayList;
import static utility.UtilMethods.printProductArrayList;


public class EmployeeMenu {

    public static void printSystemMenu() {

        System.out.println("================================== Employee Menu ============================================ ");
        System.out.println("[1] Add product");
        System.out.println("[2] Print all products");
        System.out.println("[3] Print all products sorted by name");
        System.out.println("[4] Print all products sorted by price");
        System.out.println("[5] Print all products sorted by expiration date");
        System.out.println("[6] Print product by ID");
        System.out.println("[7] Print product by name");
        System.out.println("[8] Print all products with a price higher than or equal to the user's expected price");
        System.out.println("[9] Print all products with a price lower than the user's expected price");
        System.out.println("[10] Print all products with a quantity greater than or equal to a user-specified quantity");
        System.out.println("[11] Print all products with a quantity less than a user-specified quantity");
        System.out.println("[12] Delete product (by id)");
        System.out.println("[13] Change the price of a product (by id)");
        System.out.println("[14] Change the quantity of a product (by id)");
        System.out.println("[15] Change the name of a product (by id)");
        System.out.println("[16] Sort employees by name");
        System.out.println("[17] Sort employees by salary");
        System.out.println("[18] Return to Main Menu");
        System.out.println("[19] Exit");
        System.out.println("============================================================================================= ");
        System.out.print("Your choice: ");
    }

    public static void showEmployeeMenu(Scanner sc, Statement statement) throws SQLException {

        int choice;
        Timestamp showTime = new Timestamp(System.currentTimeMillis());

        do {
            printSystemMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    createProduct(statement);
                    System.out.println("Product was created successfully at: " + showTime);
                    System.exit(0);
                }
                case 2 -> {
                    ArrayList<Product> products = printProducts(statement, QUERY_PRINT_PRODUCTS_BY_EMPLOYEE);
                    printProductArrayList(products);
                    System.out.println("Product was Printed at: " + showTime);
                    System.exit(0);
                }
                case 3 -> {
                    ArrayList<Product> products = sortProducts(statement, QUERY_SORT_PRODUCTS_BY_NAME);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Name at: " + showTime);
                    System.exit(0);
                }
                case 4 -> {
                    ArrayList<Product> products = sortProducts(statement, QUERY_SORT_PRODUCTS_BY_PRICE);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Price at: " + showTime);

                }
                case 5 -> {
                    ArrayList<Product> products = sortProducts(statement, QUERY_SORT_PRODUCTS_BY_EXPIRATION_DATE);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Expiration Date at: " + showTime);

                }

                case 6 -> {
                    ArrayList<Product> products = printProductsWhereIdIsEqualToInput(statement);
                    printProductArrayList(products);

                }
                case 7 -> {
                    ArrayList<Product> products = printProductWhereNameEqualsInput(statement);
                    printProductArrayList(products);

                }
                case 8 -> {
                    ArrayList<Product> products = printProductWithPriceHigherOrEqualToInput(statement);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Price higher than input at: " + showTime);

                }
                case 9 -> {
                    ArrayList<Product> products = printProductWithPriceLowerOrEqualToInput(statement);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Price lower than input at: " + showTime);

                }

                case 10 -> {
                    ArrayList<Product> products = printProductWithQuantityHigherOrEqualToInput(statement);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Quantity higher than input at: " + showTime);

                }
                case 11 -> {
                    ArrayList<Product> products = printProductWithQuantityLowerOrEqualToInput(statement);
                    printProductArrayList(products);
                    System.out.println("Product was sorted by Quantity lower than input at: " + showTime);

                }
                case 12 -> {
                    deleteProductWhereIdEqualsInput(statement);
                    System.out.println("Product was deleted successfully at: " + showTime);

                }
                case 13 -> {
                    changeProductPriceWhereIdEqualsInput(statement);
                    System.out.println("The price was changed successfully at: " + showTime);

                }
                case 14 -> {
                    changeProductQuantityWhereIdEqualsInput(statement);
                    System.out.println("The quantity was changed successfully at: " + showTime);


                }
                case 15 -> {
                    changeProductNameWhereIdEqualsInput(statement);
                    System.out.println("The name was changed successfully at: " + showTime);

                }

                case 16 -> {
                    ArrayList<Employee> employees = sortEmployees(statement, QUERY_SORT_EMPLOYEES_BY_NAME);
                    printEmployeeArrayList(employees);
                    System.out.println("Employees were sorted by Name at: " + showTime);

                }
                case 17 -> {
                    ArrayList<Employee> employees = sortEmployees(statement, QUERY_SORT_EMPLOYEES_BY_SALARY);
                    printEmployeeArrayList(employees);

                }
                case 18 -> showMainMenu(sc, statement, null);
                case 19 -> System.exit(0);
                default -> System.out.println("Invalid choice! Try again!\n");
            }

        } while (true);
    }
}