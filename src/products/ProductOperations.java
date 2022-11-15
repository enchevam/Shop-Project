package products;

import employee.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductOperations {
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
                String expiration_date =rs.getString(7);
                Product item = new Product(id,name,price,quantity,type,color,expiration_date);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return productsList;
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
                String expiration_date =rs.getString(7);
                Product item = new Product(id,name,price,quantity,type,color,expiration_date);
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
                String expiration_date =rs.getString(7);
                Product item = new Product(id,name,price,quantity,type,color,expiration_date);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return productsList;
    }
}


