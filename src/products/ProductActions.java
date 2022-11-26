package products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static utility.Queries.*;

public class ProductActions {

    public static ArrayList<Product> printProducts(Statement statement, String query) {
        ArrayList<Product> productsList = new ArrayList<>();
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> searchProducts(Statement statement, String query) {

        ArrayList<Product> productsList = new ArrayList<>();
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static Product searchProductsById(Statement statement, int id, int quantity) {
        ResultSet rs;
        Product product = null;
        String query = "SELECT * FROM products WHERE id = " + id + " AND quantity > 0";
        try {
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int product_quantity = rs.getInt(4);
                if (product_quantity < quantity) {
                    System.out.println("Not enough quantity!");
                } else {
                    int product_id = rs.getInt(1);
                    String product_name = rs.getString(2);
                    double price = rs.getDouble(3);
                    String product_type = rs.getString(5);
                    String color = rs.getString(6);
                    String expiration_date = rs.getString(7);
                    product = new Product(product_id, product_name, price, quantity, product_type, color, expiration_date);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return product;
    }

    public static ArrayList<Product> sortProductsByPrice(Statement statement, String query) {
        ArrayList<Product> productsList = new ArrayList<>();
        addDataToProductList(statement, productsList, query);

        return productsList;
    }


    public static ArrayList<Product> sortProductsByName(Statement statement, String query) {
        ArrayList<Product> productsList = new ArrayList<>();
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    private static void addDataToProductList(Statement statement, ArrayList<Product> productsList, String query) {
        ResultSet rs;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                String type = rs.getString(5);
                String color = rs.getString(6);
                String expiration_date = rs.getString(7);
                Product item = new Product(id, name, price, quantity, type, color, expiration_date);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}


