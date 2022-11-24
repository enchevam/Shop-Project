package products;

    public class Product {
        private final int productId;
        private String name;
        private double price;
        private int productQuantity;
        private String productType;
        private String color;
        private String expirationDate;

        public Product(int productId, String name, double price, int productQuantity, String productType, String color, String expirationDate){
            this.productId = productId;
            this.name=name;
            this.price=price;
            this.productQuantity = productQuantity;
            this.productType = productType;
            this.color=color;
            this.expirationDate = expirationDate;

        }

        public double getPrice() {
            return price;
        }

        public int getProductQuantity() {
            return productQuantity;
        }
        @Override
        public String toString() {
            return "Product{" +
                    "id=" + productId +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + productQuantity +
                    ", type='" + productType + '\'' +
                    ", color='" + color + '\'' +
                    ", expiration_date='" + expirationDate + '\'' +
                    '}';
        }
    }


