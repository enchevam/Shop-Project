package menus;

import java.sql.Statement;
import java.util.Scanner;

import static auth.Authentication.authenticate;
import static utility.UtilMethods.*;

public class LogInMenu {

    public static void showLogInMenu(Scanner sc, Statement statement) {

        int id;
        String userName;
        do {

            System.out.print("Enter your id: ");

            do {
                checkInt(sc, "Enter valid Employee id");
                id = sc.nextInt();
            } while (!checkPositive(id));

            sc.nextLine();

            System.out.print("Enter your name: ");
            userName = sc.nextLine();

            checkString(userName, sc);

        } while (!authenticate(statement, sc, id, userName));
    }

}
