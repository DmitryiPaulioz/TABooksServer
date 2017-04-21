package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.jsonhandler.JSONHandler;
import com.epam.httpserver.resources.ResponseConstants;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class UpdateBook implements ICommandHandler {
    public void handle(RequestHandler request, com.epam.httpserver.handler.ResponseHandler respond) throws IOException {
        System.out.println("Update book");
        try {
            COMMON_BOOK_STORAGE.setAllBooks(JSONHandler.readAllBooksFromJSON(JSON_SAVED_BOOKS_PATH, COMMON_BOOK_STORAGE));
            Book changedBook = COMMON_BOOK_STORAGE.getConcreteBook(0);
            changedBook.setAuthorName(changedBook.getAuthorName() + changedBook.getId());
            JSONHandler.writeAllBooksToJSON(COMMON_BOOK_STORAGE, JSON_SAVED_BOOKS_PATH);
            respond.setStatusCode(ResponseConstants.STATUS_CODE_201_CREATED);
        } catch (Exception ex) {
            respond.setStatusCode(ResponseConstants.STATUS_CODE_400_BAD_REQUEST);
        }
        respond.createResponse(respond, request);
    }
}
