import customer.Customer;

import java.util.Scanner;
import java.sql.*;

import static menus.MainMenu.showMainMenu;

public class Main {


    public static void main(String[] args) throws SQLException {

        DbConnection.connect();
        Statement statement = DbConnection.con.createStatement();

        Scanner sc = new Scanner(System.in);

        Customer customer = new Customer();

        showMainMenu(sc, statement, customer);

    }
}
