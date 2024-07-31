import java.util.Scanner;

public class TaskManagementSystem {

    // Task class
    static class Task {
        private int taskId;
        private String taskName;
        private String status;

        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        public int getTaskId() {
            return taskId;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Task Name: " + taskName + ", Status: " + status;
        }
    }

    // Node class
    static class Node {
        Task task;
        Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // TaskList class
    static class TaskList {
        private Node head;

        public TaskList() {
            this.head = null;
        }

        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public Task searchTask(int taskId) {
            Node current = head;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    return current.task;
                }
                current = current.next;
            }
            return null;
        }

        public void traverseTasks() {
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }

        public boolean deleteTask(int taskId) {
            Node current = head;
            Node previous = null;
            while (current != null) {
                if (current.task.getTaskId() == taskId) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

        public void showMenu() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nTask Management System Menu:");
                System.out.println("1. Add Task");
                System.out.println("2. Search Task");
                System.out.println("3. Traverse Tasks");
                System.out.println("4. Delete Task");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Task ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter Task Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Status: ");
                        String status = scanner.nextLine();
                        addTask(new Task(id, name, status));
                        System.out.println("Task added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter Task ID to search: ");
                        id = scanner.nextInt();
                        Task task = searchTask(id);
                        if (task != null) {
                            System.out.println("Task found: " + task);
                        } else {
                            System.out.println("Task not found.");
                        }
                        break;
                    case 3:
                        System.out.println("Traversing tasks:");
                        traverseTasks();
                        break;
                    case 4:
                        System.out.print("Enter Task ID to delete: ");
                        id = scanner.nextInt();
                        boolean deleted = deleteTask(id);
                        if (deleted) {
                            System.out.println("Task deleted successfully.");
                        } else {
                            System.out.println("Task not found.");
                        }
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.showMenu();
    }
}
