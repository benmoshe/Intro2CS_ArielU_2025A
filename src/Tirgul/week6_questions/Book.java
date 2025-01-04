/**
 * Author: Avi Rahimov
 * This class contains solutions to various exercises from week 6.
 */
package Tirgul.week6_questions;

/**
 * This class represents a book with a title, author, number of pages, and price.
 */
public class Book {
    private int price;
    private String title;
    private String author;
    private int numOfPages;

    /**
     * Constructs a new Book.
     *
     * @param title      The title of the book.
     * @param author     The author of the book.
     * @param numOfPages The number of pages in the book.
     * @param price      The price of the book.
     */
    public Book(String title, String author, int numOfPages, int price) {
        this.title = title;
        this.author = author;
        this.numOfPages = numOfPages;
        this.price = price;
    }

    /**
     * Adds one page to the book.
     */
    public void addOnePage() {
        this.numOfPages++;
    }

    /**
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return The author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @return The price of the book.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the book.
     *
     * @param price The new price of the book.
     */
    public void setPrice(int price) {
        this.price = price;
    }


//      public Book setPrice(int price){
//          this.price = price;
//          return this;
//      }


    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "J.K Rowling", 361, 75);
        book1.setPrice(100);
        book1.addOnePage();
//        book1.setPrice(100).addOnePage();
        System.out.println("Price: " + book1.getPrice());
        System.out.println("Title: " + book1.getTitle());
        System.out.println("Author: " + book1.getAuthor());
    }
}

