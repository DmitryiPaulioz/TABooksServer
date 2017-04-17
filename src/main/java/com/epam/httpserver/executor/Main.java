package com.epam.httpserver.executor;

import com.epam.httpserver.server.HttpServer;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class Main {

    private static final int UPRUNNING_PORT = 8080;
    private static final int UPRUNNING_POOL_SIZE = 4;

    public static void main(String args[]){
        HttpServer server = new HttpServer();
    }
}
