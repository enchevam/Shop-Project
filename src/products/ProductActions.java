package products;

import utility.Types;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.UtilMethods.checkInt;

public class ProductActions {
    static Scanner sc = new Scanner(System.in);
    
    public static int createProduct(Statement statement) throws SQLException {

        System.out.println("Enter new product name");
        String nameInput = sc.nextLine();
       // checkString(nameInput, sc);
        System.out.println("Enter new product price");
        double priceInput = Double.parseDouble(sc.nextLine());
        System.out.println("Enter new product quantity");
        int quantityInput;
        // checkInt( sc,"Enter an integer next time");
        quantityInput = Integer.parseInt(sc.nextLine());
        System.out.println("Enter new product type");
      //  String typeInput = sc.nextLine();
        Types.MyEnums typeInput = Types.MyEnums.valueOf(sc.nextLine().toUpperCase());
        System.out.println("Enter new product color");
        String colorInput = sc.nextLine();
        System.out.println("Enter new product expiration_date");
        String expiration_dateInput = sc.nextLine();
        String query = "INSERT INTO products(product_name,price,quantity,product_type,product_color,expiration_date) VALUES ('" + nameInput + "'," + priceInput + "," + quantityInput + ",'" + typeInput + "','" + colorInput + "','" + expiration_dateInput + "');";
        return statement.executeUpdate(query);
    }

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

    public static ArrayList<Product> sortProducts(Statement statement, String query) {
        ArrayList<Product> productsList = new ArrayList<>();
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> sortProductByPriceHigherOrEqualToInput(Statement statement) {

        double input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE price>=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> sortProductByPriceLowerOrEqualToInput(Statement statement) {

        double input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE price<=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> sortProductByQuantityHigherOrEqualToInput(Statement statement) {
        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity>=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> sortProductByQuantityLowerOrEqualToInput(Statement statement) {

        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity<=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> checkProductsWhereIdIsEqualToInput(Statement statement) {
        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE id =" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> checkProductWhereNameEqualsInput(Statement statement) {
        System.out.println("Enter product name");
        String input = sc.nextLine();
        ArrayList<Product> productsList = new ArrayList<>();

        String query = "SELECT * FROM products WHERE name LIKE '" + input + "'";
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static int deleteProductWhereIdEqualsInput(Statement statement) throws SQLException {

        System.out.println("Enter id");
        int idInput = sc.nextInt();

        String query = "DELETE FROM products WHERE id =" + idInput;

        return statement.executeUpdate(query);

    }

    public static int changeProductPriceWhereIdEqualsInput(Statement statement) throws SQLException {
        System.out.println("Enter id");
        int idInput = sc.nextInt();
        System.out.println("Set new product price:");
        double newPrice = sc.nextInt();
        String query = "UPDATE products SET price =" + newPrice + " WHERE id =" + idInput;

        return statement.executeUpdate(query);
    }

    public static int changeProductQuantityWhereIdEqualsInput(Statement statement) throws SQLException {

        System.out.println("Enter id");
        int idInput = sc.nextInt();
        System.out.println("Set new product quantity:");
        int newQuantity = sc.nextInt();
        String query = "UPDATE products SET quantity =" + newQuantity + " WHERE id =" + idInput;
        return statement.executeUpdate(query);
    }

    public static int changeProductNameWhereIdEqualsInput(Statement statement) throws SQLException {
        System.out.println("Enter id");
        int idInput = sc.nextInt();
        System.out.println("Set new product name:");
        String newName = sc.next();
        String query = "UPDATE products SET name ='" + newName + "' WHERE id =" + idInput;
        return statement.executeUpdate(query);
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

