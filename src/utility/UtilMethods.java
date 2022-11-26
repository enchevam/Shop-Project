package utility;

import employee.Employee;
import products.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class UtilMethods {

    public static void printProductArrayList(ArrayList<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public static void printEmployeeArrayList(ArrayList<Employee> employees) {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void checkString(String input, Scanner sc) {
        while (!input.matches("[a-zA-Z]+")) {
            System.out.println("Only letters are allowed");
            input = sc.nextLine();
        }
    }

    public static void checkInt(Scanner sc, String msg) {
        while (!sc.hasNextInt()) {
            System.out.println(msg);
            sc.next();
        }
    }

    public static int checkPositive(int id) {

            if (id < 0) {
                System.out.println("Not a positive; Try again");
            }
            return id;
    }
}

