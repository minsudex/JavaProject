package javaproject_used_shop.product;

public class memberRepository2 {
    public class Product {

        private String name;
        private String description;
        private int price;
        private String imageUrl;

        public

        Product(String name, String description, int price, String imageUrl)

        {
            this.name = name;
            this.description = description;
            this.price = price;
            this.imageUrl = imageUrl;
        }

        public String getName()

        {
            return name;
        }

        public String getDescription()

        {
            return description;
        }

        public

        int

        getPrice()

        {
            return price;
        }

        public String getImageUrl()

        {
            return imageUrl;
        }

    }
}
