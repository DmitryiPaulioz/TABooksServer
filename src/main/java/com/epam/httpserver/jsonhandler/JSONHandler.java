package com.epam.httpserver.jsonhandler;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.bookstorage.BookStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 4/11/2017.
 */
public class JSONHandler {

    private static final Gson gson = new GsonBuilder().create();

    public static List<Book> readAllBooksFromJSON(String jsonPath, BookStorage bookStorage) {
        try {
            bookStorage = gson.fromJson(new FileReader(jsonPath), BookStorage.class);
        } catch (IOException e) {
            System.out.println("There is no file");
            e.printStackTrace();
        }
        return bookStorage.getAllBooks();
    }

    public static void writeAllBooksToJSON(BookStorage bookStorage, String jsonPath) {
        Writer writer = null;
        try {
            bookStorage.consoleLogAllContainedBooks();
            writer = new FileWriter(jsonPath);
            gson.toJson(bookStorage, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
