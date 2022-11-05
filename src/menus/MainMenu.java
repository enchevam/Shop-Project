package menus;

import java.sql.Statement;
import java.util.Scanner;
import static menus.LogInMenu.showLogInMenu;

public class MainMenu {

    public static void printChoices() {

        System.out.println("Choose user type:");
        System.out.println("1. Employee");
        System.out.println("2. Client");

    }

    public static void showMainMenu(Scanner sc, Statement statement) {

        int choice;

        do {
            printChoices();
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    showLogInMenu(sc, statement);
                    System.exit(0);
                }
                case 2 -> {
                    System.out.println("Client");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again!\n");
            }
        } while (true);
    }
}
