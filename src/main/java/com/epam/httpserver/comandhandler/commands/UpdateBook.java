package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.book.Book;
import com.epam.httpserver.bookstorage.BookStorage;
import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.jsonhandler.JSONHandler;
import com.epam.httpserver.resources.ResponseConstants;
import org.omg.CORBA.portable.ResponseHandler;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class UpdateBook implements ICommandHandler {
    public void handle(RequestHandler request, com.epam.httpserver.handler.ResponseHandler respond) throws IOException {
        System.out.println("Update book");
        try {
            BookStorage bookStorage = new BookStorage();
            bookStorage.setAllBooks(JSONHandler.readAllBooksFromJSON(JSON_SAVED_BOOKS_PATH));
            Book changedBook = bookStorage.getConcretBook(0);
            changedBook.setAuthorName(changedBook.getAuthorName() + changedBook.getId());
            JSONHandler.writeAllBooksToJSON(bookStorage.getAllBooks(), JSON_SAVED_BOOKS_PATH);
            String contentType = request.getContentType();
            respond.setContentType(contentType);
            respond.setStatusCode(ResponseConstants.STATUS_CODE_201_CREATED);
        } catch (Exception ex) {
            respond.setStatusCode(ResponseConstants.STATUS_CODE_400_BAD_REQUEST);
        }
        respond.createResponse(respond, request);
    }
}
