package menus;

import employee.Employee;
import products.Product;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static employee.EmployeeActions.*;
import static products.ProductActions.*;
import static utility.Queries.*;
import static utility.UtilMethods.*;

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
            checkInt(sc, "Enter correct menu choice");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {

                    System.exit(0);
                }
                case 2 -> {
                    ArrayList<Product> products = printProducts(statement, QUERY_PRINT_PRODUCTS_BY_EMPLOYEE);
                    printProductArrayList(products);
                    System.exit(0);
                }
                case 3 -> {
                    ArrayList<Product> products = sortProductsByName(statement, QUERY_SORT_PRODUCTS_BY_NAME);
                    printProductArrayList(products);
                    System.exit(0);
                }
                case 4 -> {
                    ArrayList<Product> products = sortProductsByPrice(statement, QUERY_SORT_PRODUCTS_BY_PRICE);
                    printProductArrayList(products);
                    System.exit(0);
                }
                case 16 -> {
                    ArrayList<Employee> employees = sortEmployees(statement, QUERY_SORT_EMPLOYEES_BY_NAME);
                    printEmployeeArrayList(employees);
                    System.exit(0);
                }
                case 17 -> {
                    ArrayList<Employee> employees = sortEmployees(statement, QUERY_SORT_EMPLOYEES_BY_SALARY);
                    printEmployeeArrayList(employees);
                    System.exit(0);
                }
                default -> System.out.println("Invalid action! Try again!\n");
            }
        } while (true);
    }
}
