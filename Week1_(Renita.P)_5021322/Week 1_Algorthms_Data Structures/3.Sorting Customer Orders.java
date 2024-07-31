import java.util.Arrays;

public class SortingCustomerOrders {

    // Define the Order class
    public static class Order {
        private int orderId;
        private String customerName;
        private double totalPrice;

        public Order(int orderId, String customerName, double totalPrice) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.totalPrice = totalPrice;
        }

        public int getOrderId() {
            return orderId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        @Override
        public String toString() {
            return "Order ID: " + orderId + ", Customer: " + customerName + ", Total Price: $" + totalPrice;
        }
    }

    // Utility class for sorting operations
    public static class SortingUtil {

        // Bubble Sort to sort orders by totalPrice
        public static void bubbleSort(Order[] orders) {
            int n = orders.length;
            boolean swapped;
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                        // Swap orders[j] and orders[j + 1]
                        Order temp = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = temp;
                        swapped = true;
                    }
                }
                // If no two elements were swapped by inner loop, then break
                if (!swapped) break;
            }
        }

        // Quick Sort to sort orders by totalPrice
        public static void quickSort(Order[] orders, int low, int high) {
            if (low < high) {
                int pi = partition(orders, low, high);
                quickSort(orders, low, pi - 1);
                quickSort(orders, pi + 1, high);
            }
        }

        private static int partition(Order[] orders, int low, int high) {
            double pivot = orders[high].getTotalPrice();
            int i = (low - 1);
            for (int j = low; j < high; j++) {
                if (orders[j].getTotalPrice() <= pivot) {
                    i++;
                    // Swap orders[i] and orders[j]
                    Order temp = orders[i];
                    orders[i] = orders[j];
                    orders[j] = temp;
                }
            }
            // Swap orders[i + 1] and orders[high]
            Order temp = orders[i + 1];
            orders[i + 1] = orders[high];
            orders[high] = temp;

            return i + 1;
        }
    }

    public static void main(String[] args) {
        // Initialize an array of orders
        Order[] orders = {
            new Order(1, "Alice", 250.00),
            new Order(2, "Bob", 150.00),
            new Order(3, "Charlie", 300.00),
            new Order(4, "David", 100.00),
            new Order(5, "Eve", 200.00)
        };

        // Test Bubble Sort
        System.out.println("Bubble Sort:");
        Order[] ordersForBubbleSort = Arrays.copyOf(orders, orders.length);
        SortingUtil.bubbleSort(ordersForBubbleSort);
        for (Order order : ordersForBubbleSort) {
            System.out.println(order);
        }

        // Test Quick Sort
        System.out.println("\nQuick Sort:");
        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length);
        SortingUtil.quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}
