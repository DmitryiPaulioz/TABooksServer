package com.epam.httpserver.server;

import com.epam.httpserver.comandhandler.CommandHandler;
import com.epam.httpserver.comandhandler.commands.*;
import com.epam.httpserver.handler.RequestHandler;
import com.epam.httpserver.handler.ResponseHandler;
import com.epam.httpserver.resources.CommonConstants;
import jdk.nashorn.internal.runtime.GlobalConstants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private static final int DEFAULT_PORT = 8282;
    public final List<CommandHandler> handlers = new ArrayList<CommandHandler>();
    private ExecutorService pool;
    private int port;
    private int sizeOfTreadPool;

    public HttpServer(int port, int sizeOfThreadPool) {
        this.port = port;
        this.sizeOfTreadPool = sizeOfThreadPool;
    }

    public void start() throws IOException {
        pool = Executors.newFixedThreadPool(sizeOfTreadPool);
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.submit(new ClientSession(socket, this));
        }

    }

    public CommandHandler findHandler(RequestHandler rq) throws IOException {
        CommandHandler defHandler = new CommandHandler(null, null, new StepCommand());
        String methodFromRequest = rq.getMethod();
        String pathFromRequest = rq.getPath();
        for (CommandHandler handler : handlers) {
            if (methodFromRequest.equals(handler.getMethod()) && handler.getUri().contains(pathFromRequest)) {
                return handler;
            }
        }
        return defHandler;
    }

    public void addHandler(CommandHandler commandHandler) {
        handlers.add(commandHandler);
    }


}