package com.epam.httpserver.executor;

import com.epam.httpserver.comandhandler.CommandHandler;
import com.epam.httpserver.comandhandler.commands.GetAllBooks;
import com.epam.httpserver.resources.CommonConstants;
import com.epam.httpserver.server.HttpServer;

import java.io.IOException;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class Main {

    private static final int UPRUNNING_PORT = 8181;
    private static final int UPRUNNING_POOL_SIZE = 4;

    public static void main(String args[]){
        HttpServer server = new HttpServer(UPRUNNING_PORT, UPRUNNING_POOL_SIZE);
        server.addHandler(new CommandHandler(CommonConstants.GET, "/book", new GetAllBooks()));
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
