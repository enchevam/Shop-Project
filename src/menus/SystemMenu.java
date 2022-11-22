package menus;

import Products.Product;
import employee.Employee;


import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static Products.ProductOperations.*;
import static employee.EmployeeOperation.sortEmployeesByName;
import static employee.EmployeeOperation.sortEmployeesBySalary;


public class SystemMenu {

    public static void printSystemMenu() {

        System.out.println("Choose user type:");
        System.out.println("1. Add product");
        System.out.println("2. Print all products");
        System.out.println("3. Print all products sorted by name");
        System.out.println("4. Print all products sorted by price");
        System.out.println("5. Print all products sorted by expiration date");
        System.out.println("6. Print product by ID");
        System.out.println("7. Print product by name");
        System.out.println("8. Print all products with a price higher than or equal to the user's expected price");
        System.out.println("9. Print all products with a price lower than the user's expected price");
        System.out.println("10. Print all products with a quantity greater than or equal to a user-specified quantity");
        System.out.println("11. Print all products with a quantity less than a user-specified quantity");
        System.out.println("12. Delete product (by id)");
        System.out.println("13. Change the price of a product (by id)");
        System.out.println("14. Change the quantity of a product (by id)");
        System.out.println("15. Change the name of a product (by id)");
        System.out.println("16. Sort employees by name");
        System.out.println("17. Sort employees by salary");
    }

    public static void showSystemMenu(Scanner sc, Statement statement) throws SQLException {
        int choice;

        do {
            printSystemMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    int products =createProduct(statement);
                    System.out.println("Product was created successfully");
                    System.exit(0);
                }
                case 2 -> {
                    ArrayList<Product> products = printAllProducts(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 3 -> {
                    ArrayList<Product> products = sortProductsByName(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 4 -> {
                    ArrayList<Product> products = sortProductsByPrice(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 5 -> {
                    ArrayList<Product> products = sortProductsByExpiration_Date(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }

                case 6 -> {
                    ArrayList<Product> products = printProductWhereIdEqualsInput(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 7 -> {
                    ArrayList<Product> products = printProductWhereNameEqualsInput(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 8 -> {
                    ArrayList<Product> products = sortProductByPriceHigherOrEqualToInput(statement);
                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 9 -> {
                    ArrayList<Product> products = sortProductByPriceLowerOrEqualToInput(statement);

                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }

                case 10 -> {
                    ArrayList<Product> products = sortProductByQuantityHigherOrEqualToInput(statement);


                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 11 -> {
                    ArrayList<Product> products = sortProductByQuantityLowerOrEqualToInput(statement);

                    for (Product e : products) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 12 -> {
                    int products = deleteProductWhereIdEqualsInput(statement);
                        System.out.println("Product was deleted successfully");
                    System.exit(0);
                }
                case 13 -> {
                    int products = changeProductPriceWhereIdEqualsInput(statement);
                    System.out.println("The price was changed successfully!");
                    System.exit(0);
                }
                case 14 -> {
                    int products = changeProductQuantityWhereIdEqualsInput(statement);
                    System.out.println("The quantity was changed successfully!");
                    System.exit(0);
                }
                case 15 -> {
                    int products = changeProductNameWhereIdEqualsInput(statement);
                    System.out.println("The Name was changed successfully!");
                    System.exit(0);
                }

                case 16 -> {

                    ArrayList<Employee> employees = sortEmployeesByName(statement);
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 17 -> {
                    {
                        ArrayList<Employee> employees = sortEmployeesBySalary(statement);
                        for (Employee e : employees) {
                            System.out.println(e);
                        }
                        System.exit(0);
                    }

                }
                default -> System.out.println("Invalid choice! Try again!\n");
            }

        } while (true);
    }
}
