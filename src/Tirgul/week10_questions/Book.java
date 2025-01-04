package Tirgul.week10_questions;

public class Book {
    String name;
    String author;

    // Constructor to initialize book
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Override toString() method to display book details
    @Override
    public String toString() {
        return "Book Name: " + name + ", Author: " + author;
    }
}
