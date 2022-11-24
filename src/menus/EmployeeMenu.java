package menus;

import products.Product;
import employee.Employee;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static products.ProductActions.*;
import static employee.EmployeeActions.sortEmployeesByName;
import static employee.EmployeeActions.sortEmployeesBySalary;


public class EmployeeMenu {

    public static void printEmployeeMenu() {

        System.out.println("Choose employee action:");
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

    public static void showEmployeeMenu(Scanner sc, Statement statement) {
        int choice;

        do {
            printEmployeeMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {

                    System.exit(0);
                }
                case 2 -> {
                    ArrayList<Product> products = printAllProductsByCustomer(statement);
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
                case 16 -> {
                    ArrayList<Employee> employees = sortEmployeesByName(statement);
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                case 17 -> {
                    ArrayList<Employee> employees = sortEmployeesBySalary(statement);
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
                default -> System.out.println("Invalid action! Try again!\n");
            }
        } while (true);
    }
}
