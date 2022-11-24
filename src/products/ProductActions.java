package products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductActions {
    public static ArrayList<Product> printAllProducts(Statement statement) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products";
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

        return productsList;
    }

    public static ArrayList<Product> printAllProductsByCustomer(Statement statement) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity > 0";
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

        return productsList;
    }

    public static ArrayList<Product> searchProductsByCategory(Statement statement, String type) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE product_type LIKE '%" + type + "%'";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                String product_type = rs.getString(5);
                String color = rs.getString(6);
                String expiration_date = rs.getString(7);
                Product item = new Product(id, name, price, quantity, product_type, color, expiration_date);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return productsList;
    }

    public static ArrayList<Product> searchProductsByName(Statement statement, String name) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE product_name LIKE '%" + name + "%'";
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String product_name = rs.getString(2);
                double price = rs.getDouble(3);
                int quantity = rs.getInt(4);
                String product_type = rs.getString(5);
                String color = rs.getString(6);
                String expiration_date = rs.getString(7);
                Product item = new Product(id, product_name, price, quantity, product_type, color, expiration_date);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

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

    public static ArrayList<Product> sortProductsByPrice(Statement statement) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY price";
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

        return productsList;
    }

    public static ArrayList<Product> sortProductsByName(Statement statement) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY name";
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

        return productsList;
    }
}


