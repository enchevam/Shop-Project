package Products;

    public class Product {
        private final int id;
        private String name;
        private double price;
        private int quantity;
        private String type;
        private String color=null;
        private String expiration_date=null;
        Product(int id, String name, double price ,int quantity, String type,String color,String expiration_date){
            this.id=id;
            this.name=name;
            this.price=price;
            this.quantity=quantity;
            this.type=type;
            this.color=color;
            this.expiration_date=expiration_date;

        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }


        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }



        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }



        public void setName(String name) {
            this.name = name;
        }


        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", type='" + type + '\'' +
                    ", color='" + color + '\'' +
                    ", expiration_date='" + expiration_date + '\'' +
                    '}';
        }
    }


