package products;

import utility.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static utility.UtilMethods.*;

public class ProductActions {
    static Scanner sc = new Scanner(System.in);

    public static int createProduct(Statement statement) throws SQLException {

        System.out.print("Enter new product name: ");
        String nameInput = sc.nextLine();
        checkString(nameInput, sc);
        System.out.print("Enter new product price: ");
        double priceInput = Double.parseDouble(sc.nextLine());
        System.out.print("Enter new product quantity: ");
        int quantityInput;
        checkInt(sc, "Enter an integer next time");
        quantityInput = Integer.parseInt(sc.nextLine());
        Type typeInput = checkProduct(sc);
        System.out.print("Enter new product color: ");
        String colorInput = sc.nextLine();
        checkString(colorInput, sc);
        LocalDate exDate;
        String expirationDateInput;
        do {
            System.out.print("Enter new product expiration date (dd-mm-yyyy): ");
            expirationDateInput = sc.nextLine();
        }
        while (!checkValidDate(expirationDateInput));
        exDate = getFormattedDate(expirationDateInput);
        String query = "INSERT INTO products(product_name,price,quantity,product_type,product_color,expiration_date) VALUES ('" + nameInput + "'," + priceInput + "," + quantityInput + ",'" + typeInput + "','" + colorInput + "','" + exDate + "');";
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

    public static ArrayList<Product> printProductWithPriceHigherOrEqualToInput(Statement statement) {
        System.out.print("Enter price: ");
        double input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE price>=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> printProductWithPriceLowerOrEqualToInput(Statement statement) {
        System.out.print("Enter price: ");
        double input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE price<=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> printProductWithQuantityHigherOrEqualToInput(Statement statement) {
        System.out.print("Enter quantity: ");
        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity>=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> printProductWithQuantityLowerOrEqualToInput(Statement statement) {
        System.out.print("Enter quantity: ");
        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity<=" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> printProductsWhereIdIsEqualToInput(Statement statement) {
        System.out.print("Enter id: ");
        int input = sc.nextInt();
        ArrayList<Product> productsList = new ArrayList<>();
        String query = "SELECT * FROM products WHERE id =" + input;
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static ArrayList<Product> printProductWhereNameEqualsInput(Statement statement) {
        System.out.print("Enter product name: ");
        String input = sc.nextLine();
        ArrayList<Product> productsList = new ArrayList<>();

        String query = "SELECT * FROM products WHERE product_name LIKE '" + input + "'";
        addDataToProductList(statement, productsList, query);

        return productsList;
    }

    public static int deleteProductWhereIdEqualsInput(Statement statement) throws SQLException {
        int idInput = getProductIdInput(statement);
        String query = "DELETE FROM products WHERE id =" + idInput;
        return statement.executeUpdate(query);

    }


    public static int changeProductPriceWhereIdEqualsInput(Statement statement) throws SQLException {
        int idInput = getProductIdInput(statement);
        System.out.print("Set new product price:");
        double newPrice = sc.nextDouble();
        String query = "UPDATE products SET price =" + newPrice + " WHERE id =" + idInput;

        return statement.executeUpdate(query);
    }

    public static int changeProductQuantityWhereIdEqualsInput(Statement statement) throws SQLException {

        int idInput = getProductIdInput(statement);
        System.out.print("Set new product quantity:");
        int newQuantity = sc.nextInt();
        String query = "UPDATE products SET quantity =" + newQuantity + " WHERE id =" + idInput;
        return statement.executeUpdate(query);
    }

    public static int changeProductNameWhereIdEqualsInput(Statement statement) throws SQLException {
        int idInput = getProductIdInput(statement);
        System.out.print("Set new product name:");
        sc.nextLine();
        String newName = sc.nextLine();
        String query = "UPDATE products SET product_name ='" + newName + "' WHERE id =" + idInput;
        return statement.executeUpdate(query);
    }

    public static Product searchProductsById(Statement statement, int id, int quantity) {
        ResultSet rs;
        Product product = null;
        String query = "SELECT * FROM products WHERE id = " + id + " AND quantity > 0";
        try {
            rs = statement.executeQuery(query);
            if (rs.next()) {
                int prodQuantity = rs.getInt(4);
                if (prodQuantity < quantity) {
                    System.out.println("Not enough quantity!");
                } else {
                    int prodId = rs.getInt(1);
                    String prodName = rs.getString(2);
                    double price = rs.getDouble(3);
                    String prodType = rs.getString(5);
                    String color = rs.getString(6);
                    String expirationDate = rs.getString(7);
                    product = new Product(prodId, prodName, price, quantity, prodType, color, expirationDate);
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
                String expirationDate = rs.getString(7);
                Product item = new Product(id, name, price, quantity, type, color, expirationDate);
                productsList.add(item);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private static int getProductIdInput(Statement statement) {
        int idInput;
        do {
            System.out.print("Enter product id: ");
            checkInt(sc, "Input invalid id. Try again!");
            idInput = sc.nextInt();
        } while (!checkIdExists(statement, idInput));
        return idInput;
    }
}

