package com.epam.httpserver.bookstorage;

import com.epam.httpserver.book.Book;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class BookStorage {


    private List<Book> allBooks;

    public BookStorage(){
        allBooks = new LinkedList();
    }

    public List<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void addBook(Book book) {
        allBooks.add(book);
    }

    public void deleteLastBook() {
        if (!allBooks.isEmpty()) {
            allBooks.remove(allBooks.size() - 1);
        }
    }

    public void consoleLogAllContainedBooks() {
        System.out.println("Current books: ");
        for (Book book : allBooks) {
            System.out.println(book);
        }
    }

    public Book getConcreteBook(int index) {
        return (allBooks.size() > index) ? allBooks.get(index) : null;
    }

    @Override

    public String toString(){
        String result = "Current books: ";
        for (Book book : allBooks) {
            result += book.toString();
        }
        return result;
    }
}
