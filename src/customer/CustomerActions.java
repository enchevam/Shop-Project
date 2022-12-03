package customer;

import products.Product;

import java.sql.Statement;
import java.util.Scanner;

import static products.ProductActions.searchProductsById;
import static utility.UtilMethods.checkInt;

public class CustomerActions {
    public static void buyProduct(Scanner sc, Statement statement, Customer customer, int id) {
        Product product;
        do {
            System.out.print("Enter product quantity: ");
            checkInt(sc, "Enter valid data");
            int quantity = sc.nextInt();
            product = searchProductsById(statement, id, quantity);
        } while (product == null);
        customer.addToCart(product);
        for (Product p: customer.shoppingCart) {
            System.out.println(p);
        }

    }
}
