package utility;

import employee.Employee;
import products.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        while (!input.matches("[a-zA-Z ]*")) {
            System.out.println("Only letters are allowed! Try again!");
            input = sc.nextLine();
        }
    }

    public static void checkInt(Scanner sc, String msg) {
        while (!sc.hasNextInt()) {
            System.out.println(msg);
            sc.next();
        }
    }

    public static boolean checkPositive(int id) {

        if (id < 0) {
            System.out.println("Not a positive; Try again");
            return false;
        }
        return true;
    }

    public static boolean checkValidDate(String date) {

        boolean isValid;

        try {
            getFormattedDate(date);
            isValid = true;
        } catch (RuntimeException e) {
            isValid = false;
            System.out.println("Invalid date! Try again!");
        }
        return isValid;
    }

    public static LocalDate getFormattedDate(String date) {

        date = replaceDelimiter(date);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return LocalDate.parse(date, dateFormatter);
    }

    public static String replaceDelimiter(String date) {
        return date.replaceAll("[./\\s]", "-");
    }

    public static Type checkProduct(Scanner sc) {
        Type typeInput = null;
        boolean isValid;
        do {
            try {
                System.out.print("Enter new product type (food/drinks/sanitary/others): ");
                typeInput = Type.valueOf(sc.nextLine().toUpperCase());
                isValid = true;
            } catch (IllegalArgumentException e) {
                isValid = false;
                System.out.println("Invalid type! Try again!");
            }
        } while (!isValid);

        return typeInput;
    }

    public static boolean checkIdExists(Statement statement, int id) {

        ResultSet rs;
        String query = "SELECT id FROM products WHERE id='" + id + "';";
        try {
            rs = statement.executeQuery(query);
            if (!rs.next()) {
                System.out.println("This id does not exist! Try again! ");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
