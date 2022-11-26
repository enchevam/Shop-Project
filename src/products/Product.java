package products;

import java.util.Objects;

public class Product {
    private final int productId;
    private String name;
    private double price;
    private int productQuantity;
    private String productType;
    private String color;
    private String expirationDate;

    Product(int productId, String name, double price, int productQuantity, String productType, String color, String expirationDate) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.productQuantity = productQuantity;
        this.productType = productType;
        this.color = Objects.requireNonNullElse(color, "none");
        this.expirationDate = Objects.requireNonNullElse(expirationDate, "none");
    }

    public double getPrice() {
        return price;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    @Override
    public String toString() {
        return "Product" + '\n' +
                "id: " + productId + '\n' +
                "Name: " + name + '\n' +
                "Price: " + price + '\n' +
                "Quantity: " + productQuantity + '\n' +
                "Type: " + productType + '\n' +
                "Color:  "+ color + '\n' +
                "Expiration Date: " + expirationDate + '\n' + "----------------------------- \n";
    }
}


