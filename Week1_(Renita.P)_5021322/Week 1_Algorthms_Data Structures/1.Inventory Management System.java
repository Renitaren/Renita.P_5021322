import java.util.*;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + productName + ", Quantity: " + quantity + ", Price: $" + price;
    }
}

class InventoryManagementSystem {
    private Map<Integer, Product> inventory;

    public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (!inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Product already exists.");
        }
    }

    public void updateProduct(int productId, int quantity, double price) {
        if (inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found!");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found!");
        }
    }

    public Product getProduct(int productId) {
        return inventory.get(productId);
    }

    public void listAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : inventory.values()) {
                System.out.println(product);
            }
        }
    }

    public void searchProductByName(String productName) {
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Product not found!");
        }
    }

    public void filterProductsByPriceRange(double minPrice, double maxPrice) {
        boolean found = false;
        for (Product product : inventory.values()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in the given price range.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. List All Products");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Filter Products by Price Range");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int addProductId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addProductName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    ims.addProduct(new Product(addProductId, addProductName, addQuantity, addPrice));
                    break;
                case 2:
                    System.out.print("Enter Product ID to update: ");
                    int updateProductId = scanner.nextInt();
                    System.out.print("Enter new Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter new Price: ");
                    double updatePrice = scanner.nextDouble();
                    ims.updateProduct(updateProductId, updateQuantity, updatePrice);
                    break;
                case 3:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteProductId = scanner.nextInt();
                    ims.deleteProduct(deleteProductId);
                    break;
                case 4:
                    ims.listAllProducts();
                    break;
                case 5:
                    System.out.print("Enter Product Name to search: ");
                    String searchName = scanner.nextLine();
                    ims.searchProductByName(searchName);
                    break;
                case 6:
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    ims.filterProductsByPriceRange(minPrice, maxPrice);
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Inventory Management System.");
    }
}
