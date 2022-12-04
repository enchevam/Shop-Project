import customer.Customer;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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
