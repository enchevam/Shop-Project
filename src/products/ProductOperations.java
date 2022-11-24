package products;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductOperations {
    static Scanner scan =new Scanner(System.in);
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
    public static int createProduct(Statement statement) throws SQLException {
        System.out.println("Enter new product id");
        int idInput = scan.nextInt();
        System.out.println("Enter new product name");
        String nameInput = scan.next();
        System.out.println("Enter new product price");
        double priceInput =scan.nextDouble();
        System.out.println("Enter new product quantity");
        int quantityInput = scan.nextInt();
        System.out.println("Enter new product type");
        String typeInput = scan.next();
        System.out.println("Enter new product color");
        String colorInput =scan.next();
        System.out.println("Enter new product expiration_date");
        String expiration_dateInput = scan.next();
        String query = "INSERT INTO products(id,name,price,quantity,type,color,expiration_date) VALUES ("+idInput+",'"+nameInput+"',"+ priceInput +","+quantityInput+",'"+typeInput+"','"+colorInput+"','"+expiration_dateInput+"');";
        return  statement.executeUpdate(query);
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
    public static ArrayList<Product> sortProductsByExpiration_Date(Statement statement) {
        ResultSet rs;
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products ORDER BY expiration_date";
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
    public static ArrayList<Product> sortProductByPriceHigherOrEqualToInput(Statement statement) {
        ResultSet rs;
        double input=scan.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where price>="+input;
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

    public static ArrayList<Product> sortProductByPriceLowerOrEqualToInput(Statement statement) {
        ResultSet rs;
        double input=scan.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where price<="+input;
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
    public static ArrayList<Product> sortProductByQuantityHigherOrEqualToInput(Statement statement) {
        ResultSet rs;
        int input=scan.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where quantity>="+input;
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

    public static ArrayList<Product> sortProductByQuantityLowerOrEqualToInput(Statement statement) {
        ResultSet rs;
        int input=scan.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where quantity<="+input;
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
    public static ArrayList<Product> printProductWhereIdEqualsInput(Statement statement) {
        ResultSet rs;
        int input=scan.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where id ="+input;
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
    public static ArrayList<Product> printProductWhereNameEqualsInput(Statement statement) {
        ResultSet rs;
        String input=scan.next();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products where name like '"+input+"'";
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
    public static int deleteProductWhereIdEqualsInput(Statement statement) throws SQLException {

        System.out.println("Enter id");
        int idInput=scan.nextInt();

        String query = "DELETE FROM products where id ="+idInput;
        return  statement.executeUpdate(query);


    }
    public static int changeProductPriceWhereIdEqualsInput(Statement statement) throws SQLException {
        System.out.println("Enter id");
        int idInput=scan.nextInt();
        System.out.println("Set new product price:");
        double newPrice=scan.nextInt();
        String query = "UPDATE products SET price ="+newPrice+" WHERE id ="+idInput;
        return  statement.executeUpdate(query);
    }
    public static int changeProductQuantityWhereIdEqualsInput(Statement statement) throws SQLException {
        System.out.println("Enter id");
        int idInput=scan.nextInt();
        System.out.println("Set new product quantity:");
        int newQuantity=scan.nextInt();
        String query = "UPDATE products SET quantity ="+newQuantity+" WHERE id ="+idInput;
        return  statement.executeUpdate(query);
    }
    public static int changeProductNameWhereIdEqualsInput(Statement statement) throws SQLException {
        System.out.println("Enter id");
        int idInput=scan.nextInt();
        System.out.println("Set new product name:");
        String newName=scan.next();
        String query = "UPDATE products SET name ='"+newName+"' WHERE id ="+idInput;
        return  statement.executeUpdate(query);
    }
}
