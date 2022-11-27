package customer;

import products.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    List<Product> shoppingCart;

    public Customer(){
        this.shoppingCart = new ArrayList<>();
    }

    public Customer(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void addToCart(Product product){
        shoppingCart.add(product);
    }

    public double calculateTotalSum(){

        double sum = 0;
        for (Product p: shoppingCart) {
            sum += p.getProductPrice() * p.getProductQuantity();
        }

        return sum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "shoppingCart=" + shoppingCart +
                '}';
    }
}
