package menus;

import customer.Customer;

import java.sql.Statement;
import java.util.Scanner;


import static menus.CustomerMenu.showCustomerMenu;
import static menus.LogInMenu.showLogInMenu;

public class MainMenu {

    public static void printChoices() {

        System.out.println("============= Main Menu ============= ");
        System.out.println("[1] Employee");
        System.out.println("[2] Customer");
        System.out.println("[3] Exit");
        System.out.println("===================================== ");
        System.out.print("Your choice: ");

    }

    public static void showMainMenu(Scanner sc, Statement statement, Customer customer) {

        int choice;
        try {
            do {
                printChoices();
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        showLogInMenu(sc, statement);
                        System.exit(0);
                    }
                    case 2 -> {
                        showCustomerMenu(sc, statement, customer);
                        System.exit(0);
                    }
                    case 3 -> System.exit(0);
                    default -> System.out.println("Invalid choice! Try again!\n");
                }
            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
