package auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import static menus.EmployeeMenu.showEmployeeMenu;

public class Authentication {

    public static boolean authenticate(Statement statement, Scanner sc, int id, String userName) {

        ResultSet rs;
        String query = "SELECT id, first_name FROM employee WHERE id='"
                + id + "' AND first_name='"
                + userName + "';";
        try {
            rs = statement.executeQuery(query);
            if (rs.next()) {
                showEmployeeMenu(sc,statement);
            }
            else {
                System.out.println("Invalid first name or id");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

}
