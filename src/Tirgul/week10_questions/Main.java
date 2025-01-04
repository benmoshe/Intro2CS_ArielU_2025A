package Tirgul.week10_questions;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create a simple tree
        TreeNode_After_Solutions root = new TreeNode_After_Solutions(10);
        root.left = new TreeNode_After_Solutions(5);
        root.left.left = new TreeNode_After_Solutions(2);
        root.left.right = new TreeNode_After_Solutions(8);

        System.out.println("Before right rotation:");
        root.printTree();

        // Perform right rotation
        root = root.rightRotate(root);

        System.out.println("\nAfter right rotation:");
        root.printTree();


        // Book list menu
        Scanner scanner = new Scanner(System.in);
        BookList bookList = new BookList();

        // Infinite loop to keep the menu running
        while (true) {
            System.out.println("\nEnter 'Add' to add a book, 'Delete' to delete a book, 'Show' to show all books, or 'Exit' to quit:");
            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Exit")) {
                break;
            } else if (choice.equalsIgnoreCase("Add")) {
                System.out.print("Enter book name: ");
                String name = scanner.nextLine();
                System.out.print("Enter author name: ");
                String author = scanner.nextLine();
                Book book = new Book(name, author);
                bookList.addBook(book);
                System.out.println("Book added: " + book);
            } else if (choice.equalsIgnoreCase("Delete")) {
                System.out.print("Enter the name of the book to delete: ");
                String bookName = scanner.nextLine();
                bookList.deleteBook(bookName);
            } else if (choice.equalsIgnoreCase("Show")) {
                bookList.showBooks();
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
