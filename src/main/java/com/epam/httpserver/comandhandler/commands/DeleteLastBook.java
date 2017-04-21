package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.jsonhandler.JSONHandler;
import com.epam.httpserver.resources.ResponseConstants;
import com.epam.httpserver.handler.ResponseHandler;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class DeleteLastBook implements ICommandHandler {
    public void handle(RequestHandler request, ResponseHandler respond) throws IOException {
        System.out.println("Delete book");
        try {
            COMMON_BOOK_STORAGE.setAllBooks(JSONHandler.readAllBooksFromJSON(JSON_SAVED_BOOKS_PATH, COMMON_BOOK_STORAGE));
            COMMON_BOOK_STORAGE.deleteLastBook();
            JSONHandler.writeAllBooksToJSON(COMMON_BOOK_STORAGE, JSON_SAVED_BOOKS_PATH);
            respond.setStatusCode(ResponseConstants.STATUS_CODE_201_CREATED);
        } catch (Exception ex) {
            respond.setStatusCode(ResponseConstants.STATUS_CODE_400_BAD_REQUEST);
        }
        respond.createResponse(respond, request);
    }
}
