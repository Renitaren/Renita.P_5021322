import java.util.Arrays;

public class ECommerceSearch {

    // Define the Product class
    public static class Product {
        private int productId;
        private String productName;
        private String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public String getCategory() {
            return category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    // Utility class for search operations
    public static class SearchUtil {

        // Linear search for an array of products
        public static Product linearSearch(Product[] products, int targetId) {
            for (Product product : products) {
                if (product.getProductId() == targetId) {
                    return product;
                }
            }
            return null; // Product not found
        }

        // Binary search for a sorted array of products
        public static Product binarySearch(Product[] products, int targetId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (products[mid].getProductId() == targetId) {
                    return products[mid];
                } else if (products[mid].getProductId() < targetId) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; // Product not found
        }
    }

    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Coffee Maker", "Appliances"),
            new Product(4, "Desk Chair", "Furniture"),
            new Product(5, "Washing Machine", "Appliances")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Test Linear Search
        System.out.println("Linear Search:");
        Product foundProductLinear = SearchUtil.linearSearch(products, 3);
        if (foundProductLinear != null) {
            System.out.println("Found: " + foundProductLinear);
        } else {
            System.out.println("Product not found.");
        }

        // Test Binary Search
        System.out.println("Binary Search:");
        Product foundProductBinary = SearchUtil.binarySearch(products, 3);
        if (foundProductBinary != null) {
            System.out.println("Found: " + foundProductBinary);
        } else {
            System.out.println("Product not found.");
        }
    }
}
