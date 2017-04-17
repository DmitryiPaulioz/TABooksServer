package com.epam.httpserver.server;

import com.epam.httpserver.handler.RequestHandler;
import org.omg.CORBA.portable.ResponseHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

 class ClientSession implements Runnable {

    private RequestHandler rq;
    private ResponseHandler rp;
    private Socket socket;

    public ClientSession(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        /*try {
            rq = new Request(new BufferedReader(new InputStreamReader(socket.getInputStream())));
            rp = new Response(socket.getOutputStream());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        try {

            Handler handlerForInvoke = findHendler(rq);
            handlerForInvoke.getiHandle().handle(rq, rp);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}