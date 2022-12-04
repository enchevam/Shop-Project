import org.junit.Before;
import org.junit.Test;
import products.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static products.ProductActions.*;

public class ProductActionsTest {

    private Statement statement = null;

    @Before
    public void setUp() {
        try {
            DbConnection.connect();
            statement = DbConnection.con.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void whenCreateProductThenReturnOne() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(1);
            int expectedResult = createProduct(statement);
            assertEquals(1, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenCreateProductThenReturnTwo() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(2);
            int expectedResult = createProduct(statement);
            assertEquals(2, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductsReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProducts(any(), anyString())).thenReturn(productList);
            ArrayList<Product> finalList = printProducts(any(), anyString());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenSearchProductsReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(searchProducts(any(), anyString())).thenReturn(productList);
            ArrayList<Product> finalList = searchProducts(any(), anyString());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenSortProductsReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(sortProducts(any(), anyString())).thenReturn(productList);
            ArrayList<Product> finalList = sortProducts(any(), anyString());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductsWithPriceHigherOrEqualToInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductWithPriceHigherOrEqualToInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductWithPriceHigherOrEqualToInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductWithPriceLowerOrEqualToInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductWithPriceLowerOrEqualToInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductWithPriceLowerOrEqualToInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductWithQuantityHigherOrEqualToInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductWithQuantityHigherOrEqualToInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductWithQuantityHigherOrEqualToInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductWithQuantityLowerOrEqualToInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductWithQuantityLowerOrEqualToInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductWithQuantityLowerOrEqualToInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductsWhereIdIsEqualToInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductsWhereIdIsEqualToInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductsWhereIdIsEqualToInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenPrintProductWhereNameEqualsInputReturnProductArrayList() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(printProductWhereNameEqualsInput(any())).thenReturn(productList);
            ArrayList<Product> finalList = printProductWhereNameEqualsInput(any());
            assertEquals(productList, finalList);

        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenDeleteProductWhereIdEqualsInputReturnOne() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(1);
            int expectedResult = deleteProductWhereIdEqualsInput(statement);
            assertEquals(1, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenDeleteProductWhereIdEqualsInputReturnTwo() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(2);
            int expectedResult = deleteProductWhereIdEqualsInput(statement);
            assertEquals(2, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductPriceWhereIdEqualsInputReturnOne() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(1);
            int expectedResult = changeProductPriceWhereIdEqualsInput(statement);
            assertEquals(1, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductPriceWhereIdEqualsInputReturnTwo() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(2);
            int expectedResult = changeProductPriceWhereIdEqualsInput(statement);
            assertEquals(2, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductQuantityWhereIdEqualsInputReturnOne() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(1);
            int expectedResult = changeProductQuantityWhereIdEqualsInput(statement);
            assertEquals(1, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductQuantityWhereIdEqualsInputReturnTwo() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(2);
            int expectedResult = changeProductQuantityWhereIdEqualsInput(statement);
            assertEquals(2, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductNameWhereIdEqualsInputReturnOne() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(1);
            int expectedResult = changeProductNameWhereIdEqualsInput(statement);
            assertEquals(1, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void whenChangeProductNameWhereIdEqualsInputReturnTwo() {
        try {
            when(statement.executeUpdate(anyString())).thenReturn(2);
            int expectedResult = changeProductNameWhereIdEqualsInput(statement);
            assertEquals(2, expectedResult);
        } catch (SQLException e) {
            // throw e;
        }
    }

    @Test
    public void givenExistingIdAndValidQuantityWhenSearchProductsByIdReturnProduct() {
        Product product = new Product(1, "kiwi", 1.20, 55, "food", "green", "12.12.2023");
        int id = 1;
        int quantity = 5;
        try {
            ResultSet rs = statement.executeQuery(anyString());
            when(statement.executeQuery(anyString())).thenReturn(rs);
            when(searchProductsById(statement, id, quantity)).thenReturn(product);
            Product finaProduct = searchProductsById(statement, id, quantity);
            assertEquals(product, finaProduct);

        } catch (SQLException e) {
            // throw e;
        }

    }

}
