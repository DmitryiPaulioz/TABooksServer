package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.bookstorage.BookStorage;
import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.handler.ResponseHandler;

import java.io.IOException;
import java.util.List;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class GetAllBooks implements ICommandHandler {
    public void handle(RequestHandler request, ResponseHandler respond) throws IOException {
        System.out.println("Get all books");
        BookStorage bookStorage = new BookStorage();
        String body = "";
        String contentType = request.getContentType();
        respond.setContentType(contentType);
    }
}
