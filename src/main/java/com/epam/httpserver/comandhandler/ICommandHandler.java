package com.epam.httpserver.comandhandler;

import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.handler.ResponseHandler;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public interface ICommandHandler {
    void handle(RequestHandler request, ResponseHandler respond) throws IOException;
}
