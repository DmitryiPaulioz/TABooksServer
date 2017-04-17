package com.epam.httpserver.bookstorage;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.jsonhandler.JSONHandler;

import java.util.LinkedList;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class BookStorage {
    private LinkedList<Book> allBooks = null;
    JSONHandler handlerOfJSON = null;

    public BookStorage(){
        if (allBooks == null) {
            handlerOfJSON = new JSONHandler();
            allBooks = handlerOfJSON.readAllBooksFromJSON();
        }
    }

    public LinkedList<Book> getAllBooks() {
        return allBooks;
    }
}
