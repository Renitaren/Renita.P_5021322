import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {
    
    private static ArrayList<Book> books = new ArrayList<>();

    // Linear search to find book by title
    public static Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search to find book by title (list must be sorted by title)
    public static Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);

            int comparison = midBook.title.compareToIgnoreCase(title);
            if (comparison == 0) {
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Method to display menu and handle user input
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Management System Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Search Book by Title (Linear Search)");
            System.out.println("3. Search Book by Title (Binary Search)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = scanner.nextLine();
                    books.add(new Book(bookId, title, author));
                    System.out.println("Book added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Book Title to search: ");
                    String linearSearchTitle = scanner.nextLine();
                    Book linearSearchResult = linearSearchByTitle(linearSearchTitle);
                    System.out.println("Linear Search Result:");
                    if (linearSearchResult != null) {
                        System.out.println(linearSearchResult);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 3:
                    // Sort books by title for binary search
                    Collections.sort(books, Comparator.comparing(book -> book.title));
                    System.out.print("Enter Book Title to search: ");
                    String binarySearchTitle = scanner.nextLine();
                    Book binarySearchResult = binarySearchByTitle(binarySearchTitle);
                    System.out.println("Binary Search Result:");
                    if (binarySearchResult != null) {
                        System.out.println(binarySearchResult);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        // Sample data for demonstration
        books.add(new Book(1, "Java Programming", "John Doe"));
        books.add(new Book(2, "Data Structures", "Jane Doe"));
        books.add(new Book(3, "Algorithms", "Alice Smith"));
        books.add(new Book(4, "Database Management", "Bob Brown"));

        // Display the menu
        displayMenu();
    }
}
