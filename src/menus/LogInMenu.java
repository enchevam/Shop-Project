package menus;

import java.sql.Statement;
import java.util.Scanner;

import static auth.Authentication.authenticate;

public class LogInMenu {

    public static void showLogInMenu(Scanner sc, Statement statement) {

        int id;
        String userName;

        do {

            System.out.println("Enter your id: ");
            id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter your name: ");
            userName = sc.nextLine();
        } while (!authenticate(statement, sc, id, userName));

    }

}
