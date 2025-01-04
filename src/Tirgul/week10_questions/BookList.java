package Tirgul.week10_questions;
import java.util.LinkedList;
public class BookList {
    LinkedList<Book> books;

    // Constructor to initialize the books list
    public BookList() {
        this.books = new LinkedList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the list.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to delete a book by name
    public void deleteBook(String bookName) {
        boolean found = false;
        for (Book book : books) {
            if (book.name.equalsIgnoreCase(bookName)) {
                books.remove(book);
                found = true;
                System.out.println("Book removed: " + book);
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}
