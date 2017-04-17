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

    private final String JSON_PATH = "";
    private LinkedList<Book> books = null;
    private static final Gson gson = new Gson();

    public LinkedList readAllBooksFromJSON() {
        try {
            books = gson.fromJson(new BufferedReader(new FileReader(JSON_PATH)), LinkedList.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void writeAllBooksToJSON(LinkedList<Book> books) {
        FileWriter writer;
        try {
            writer = new FileWriter(JSON_PATH);
            writer.write(gson.toJson(books));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            writer = null;
        }
    }
}
