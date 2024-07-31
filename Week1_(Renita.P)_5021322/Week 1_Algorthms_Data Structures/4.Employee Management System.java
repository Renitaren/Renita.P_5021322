import java.util.Scanner;

public class EmployeeManagementSystem {
    // Define the Employee class
    static class Employee {
        private int employeeId;
        private String name;
        private String position;
        private double salary;

        // Constructor
        public Employee(int employeeId, String name, String position, double salary) {
            this.employeeId = employeeId;
            this.name = name;
            this.position = position;
            this.salary = salary;
        }

        // Getters
        public int getEmployeeId() { return employeeId; }
        public String getName() { return name; }
        public String getPosition() { return position; }
        public double getSalary() { return salary; }

        // Setters
        public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }
        public void setName(String name) { this.name = name; }
        public void setPosition(String position) { this.position = position; }
        public void setSalary(double salary) { this.salary = salary; }

        @Override
        public String toString() {
            return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
        }
    }

    private static final int MAX_EMPLOYEES = 100; // Max number of employees
    private Employee[] employeeArray = new Employee[MAX_EMPLOYEES];
    private int currentSize = 0; // To keep track of the number of employees

    // Method to add an employee
    public void addEmployee(int id, String name, String position, double salary) {
        if (currentSize < MAX_EMPLOYEES) {
            employeeArray[currentSize] = new Employee(id, name, position, salary);
            currentSize++;
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Method to search for an employee by ID
    public Employee searchEmployee(int id) {
        for (int i = 0; i < currentSize; i++) {
            if (employeeArray[i].getEmployeeId() == id) {
                return employeeArray[i];
            }
        }
        return null; // Not found
    }

    // Method to traverse and display all employees
    public void traverseEmployees() {
        if (currentSize == 0) {
            System.out.println("No employees to display.");
            return;
        }
        for (int i = 0; i < currentSize; i++) {
            System.out.println(employeeArray[i]);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int id) {
        for (int i = 0; i < currentSize; i++) {
            if (employeeArray[i].getEmployeeId() == id) {
                // Shift elements to the left
                for (int j = i; j < currentSize - 1; j++) {
                    employeeArray[j] = employeeArray[j + 1];
                }
                employeeArray[currentSize - 1] = null; // Clear the last element
                currentSize--;
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Main method to display menu and handle user input
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(id, name, position, salary);
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = scanner.nextInt();
                    Employee emp = ems.searchEmployee(searchId);
                    if (emp != null) {
                        System.out.println("Employee Found: " + emp);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 3:
                    System.out.println("Displaying all employees:");
                    ems.traverseEmployees();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.deleteEmployee(deleteId);
                    System.out.println("Employee deleted if ID was found.");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
