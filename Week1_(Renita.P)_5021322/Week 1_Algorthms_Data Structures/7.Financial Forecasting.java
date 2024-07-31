import java.util.Scanner;

public class FinancialForecastingTool {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {
        if (periods == 0) {
            return initialValue;
        } else {
            return calculateFutureValue(initialValue * (1 + growthRate), growthRate, periods - 1);
        }
    }

    // Method to calculate future value with memoization
    public static double calculateFutureValueMemoized(double initialValue, double growthRate, int periods, double[] memo) {
        if (periods == 0) {
            return initialValue;
        } else if (memo[periods] != -1) {
            return memo[periods];
        } else {
            memo[periods] = calculateFutureValueMemoized(initialValue * (1 + growthRate), growthRate, periods - 1, memo);
            return memo[periods];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nFinancial Forecasting Tool");
            System.out.println("1. Calculate Future Value (without memoization)");
            System.out.println("2. Calculate Future Value (with memoization)");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter initial value: ");
                    double initialValue = scanner.nextDouble();
                    
                    System.out.print("Enter growth rate (as a decimal): ");
                    double growthRate = scanner.nextDouble();
                    
                    System.out.print("Enter number of periods: ");
                    int periods = scanner.nextInt();
                    
                    // Using recursion to calculate future value
                    double futureValue = calculateFutureValue(initialValue, growthRate, periods);
                    System.out.println("Future value (without memoization): " + futureValue);
                    break;
                
                case 2:
                    System.out.print("Enter initial value: ");
                    initialValue = scanner.nextDouble();
                    
                    System.out.print("Enter growth rate (as a decimal): ");
                    growthRate = scanner.nextDouble();
                    
                    System.out.print("Enter number of periods: ");
                    periods = scanner.nextInt();
                    
                    // Using memoization to calculate future value
                    double[] memo = new double[periods + 1];
                    for (int i = 0; i < memo.length; i++) {
                        memo[i] = -1; // Initialize memo array with -1
                    }
                    double futureValueMemoized = calculateFutureValueMemoized(initialValue, growthRate, periods, memo);
                    System.out.println("Future value (with memoization): " + futureValueMemoized);
                    break;
                
                case 3:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
