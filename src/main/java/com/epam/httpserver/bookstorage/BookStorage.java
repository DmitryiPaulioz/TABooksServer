package com.epam.httpserver.bookstorage;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.jsonhandler.JSONHandler;

import java.util.LinkedList;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class BookStorage {


    private LinkedList<Book> allBooks = null;

    public LinkedList<Book> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(LinkedList<Book> allBooks) {
        this.allBooks = allBooks;
    }

    public void addBook(Book book){
        allBooks.add(book);
    }
    public void deleteLastBook(){
        if(!allBooks.isEmpty()){
            allBooks.removeLast();
        }
    }

    public Book getConcretBook(int index){
        return (allBooks.size() > index) ? allBooks.get(index) : null;
    }
}
