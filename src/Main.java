import employee.Employee;

import java.util.Scanner;
import java.sql.*;

import static menus.MainMenu.showMainMenu;

public class Main {
    public static void main(String[] args) throws SQLException {

        DbConnection.connect();
        Statement statement = DbConnection.con.createStatement();

        Scanner sc = new Scanner(System.in);

        Employee user = new Employee("Mariqs", "Petrova", 40, 850);

        showMainMenu(sc, statement);

    }
}
