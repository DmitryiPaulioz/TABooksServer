package com.epam.httpserver.server;

import com.epam.httpserver.comandhandler.CommandHandler;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.handler.ResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class ClientSession implements Runnable {

    private RequestHandler request;
    private ResponseHandler response;
    private Socket socket;
    private HttpServer specificServer;

    public ClientSession(Socket socket, HttpServer server) {
        this.socket = socket;
        this.specificServer = server;
    }

    public void run() {
        try {
            request = new RequestHandler(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            response = new ResponseHandler(socket.getOutputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {

            CommandHandler handlerForInvoke = specificServer.findHandler(request);
            handlerForInvoke.getICommandHandler().handle(request, response);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}