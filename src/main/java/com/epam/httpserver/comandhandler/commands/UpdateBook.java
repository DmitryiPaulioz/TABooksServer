package com.epam.httpserver.comandhandler.commands;

import com.epam.httpserver.comandhandler.ICommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import org.omg.CORBA.portable.ResponseHandler;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class UpdateBook implements ICommandHandler {
    public void handle(RequestHandler request, com.epam.httpserver.handler.ResponseHandler respond) throws IOException {
        System.out.println("Update book");
    }
}
