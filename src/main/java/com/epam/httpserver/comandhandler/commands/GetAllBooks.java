package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.bookstorage.BookStorage;
import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.handler.ResponseHandler;
import com.epam.httpserver.jsonhandler.JSONHandler;
import com.epam.httpserver.resources.ResponseConstants;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class GetAllBooks implements ICommandHandler {


    public void handle(RequestHandler request, ResponseHandler respond) throws IOException {
        System.out.println("Get all books");
        try {
            BookStorage bookStorage = new BookStorage();
            bookStorage.setAllBooks(JSONHandler.readAllBooksFromJSON(JSON_SAVED_BOOKS_PATH));
            String body = JSONHandler.convertJSONToString(bookStorage.getAllBooks());
            System.out.println(body);
            String contentType = request.getContentType();
            respond.setContentType(contentType);
            respond.setStatusCode(ResponseConstants.STATUS_CODE_200_OK);
        } catch (Exception e) {
            respond.setStatusCode(ResponseConstants.STATUS_CODE_400_BAD_REQUEST);
        }
    }
}
