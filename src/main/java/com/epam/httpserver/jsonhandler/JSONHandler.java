package com.epam.httpserver.jsonhandler;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.bookstorage.BookStorage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Dmitryi_Paulioz on 4/11/2017.
 */
public class JSONHandler {

    private static final Gson gson = new GsonBuilder().create();
    private static final ReentrantLock inputLock = new ReentrantLock();
    private static final ReentrantLock outputLock = new ReentrantLock();

    public static List<Book> readAllBooksFromJSON(String jsonPath, BookStorage bookStorage) {
        inputLock.lock();
        try {

            if(bookStorage.countOfBooksInStotage() == 0) {
                bookStorage = gson.fromJson(new FileReader(jsonPath), BookStorage.class);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputLock.isLocked()){
                inputLock.unlock();
            }
        }
        return bookStorage.getAllBooks();
    }

    public static void writeAllBooksToJSON(BookStorage bookStorage, String jsonPath) {
        Writer writer = null;
        outputLock.lock();
        try {
            bookStorage.consoleLogAllContainedBooks();
            writer = new FileWriter(jsonPath);
            gson.toJson(bookStorage, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(outputLock.isLocked()){
                outputLock.unlock();
            }
        }
    }
}
