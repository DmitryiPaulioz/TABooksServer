package com.epam.httpserver.jsonhandler;

import com.epam.httpserver.book.Book;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 4/11/2017.
 */
public class JSONHandler {

    private static LinkedList<Book> books = new LinkedList<Book>();
    private static final Gson gson = new Gson();

    public static LinkedList readAllBooksFromJSON(String jsonPath) {
        System.out.println("JSON read");
        try {
            books = gson.fromJson(new BufferedReader(new FileReader(jsonPath)), LinkedList.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public static String convertJSONToString(LinkedList<Book> books) {
        return gson.toJson(books, books.getClass());
    }

    public static void writeAllBooksToJSON(LinkedList<Book> books, String jsonPath) {
        FileWriter writer;
        try {
            writer = new FileWriter(jsonPath);
            writer.write(gson.toJson(books));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            writer = null;
        }
    }
}
