package products;

    public class Product {
        private final int productId;
        private String productName;
        private double productPrice;
        private int productQuantity;
        private String productType;
        private String productColor;
        private String productExpirationDate;

        public Product(int productId, String productName, double productPrice, int productQuantity, String productType, String productColor, String productExpirationDate){
            this.productId = productId;
            this.productName = productName;
            this.productPrice = productPrice;
            this.productQuantity = productQuantity;
            this.productType = productType;
            this.productColor = productColor;
            this.productExpirationDate = productExpirationDate;

        }

        public double getProductPrice() {
            return productPrice;
        }

        public int getProductQuantity() {
            return productQuantity;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "id=" + productId +
                    ", name='" + productName + '\'' +
                    ", price=" + productPrice +
                    ", quantity=" + productQuantity +
                    ", type='" + productType + '\'' +
                    ", color='" + productColor + '\'' +
                    ", expiration_date='" + productExpirationDate + '\'' +
                    '}';
        }
    }


