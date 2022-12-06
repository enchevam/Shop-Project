package utility;

public class Queries {
    public static final String QUERY_PRINT_PRODUCTS_BY_CUSTOMER = "SELECT * FROM products WHERE quantity > 0";
    public static final String QUERY_PRINT_PRODUCTS_BY_EMPLOYEE = "SELECT * FROM products";
    public static final String QUERY_SORT_PRODUCTS_BY_PRICE = "SELECT * FROM products ORDER BY price";
    public static final String QUERY_SORT_PRODUCTS_BY_NAME = "SELECT * FROM products ORDER BY product_name";
    public static final String QUERY_SORT_PRODUCTS_BY_EXPIRATION_DATE = "SELECT * FROM products ORDER BY expiration_date";
    public static final String QUERY_SEARCH_PRODUCTS_BY_TYPE = "SELECT * FROM products WHERE product_type LIKE '%";
    public static final String QUERY_SEARCH_PRODUCTS_BY_NAME = "SELECT * FROM products WHERE product_name LIKE '%";
    public static final String QUERY_SORT_EMPLOYEES_BY_NAME = "SELECT * FROM employee ORDER BY first_name";
    public static final String QUERY_SORT_EMPLOYEES_BY_SALARY = "SELECT * FROM employee ORDER BY salary";
}
