package com.epam.httpserver.server;

import com.epam.httpserver.comandhandler.CommandHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {

    private static final int DEFAULT_PORT = 8282;
    private final List<CommandHandler> handlers = new ArrayList<CommandHandler>();
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
            pool.submit(new ClientSession(socket));
        }
    }

    /*public CommandHandler findHandler(ResponseHandler rq) throws IOException {
        Handler defHandler = new Handler(null, null, new DefHandler());
        String methodFromRequest = rq.getMethod();
        String pathFromRequest = rq.getPath();

        for (Handler handler : handlers) {
            if (methodFromRequest.equals(handler.getMethod()) && MatcherUtils.isMatches(handler.getUri(), pathFromRequest)) {
                return handler;
            }
        }
        return defHandler;
    }*/

    public void addHandler(CommandHandler commandHandler){
        handlers.add(commandHandler);
    }

}