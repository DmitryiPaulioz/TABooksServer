package com.epam.httpserver.comandhandler;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class CommandHandler {
    private String method;
    private String uri;
    private ICommandHandler iCommandHandler;

    public CommandHandler(String method, String uri, ICommandHandler iCommandHandler) {
        this.method = method;
        this.uri = uri;
        this.iCommandHandler = iCommandHandler;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public ICommandHandler getICommandHandler() {
        return iCommandHandler;
    }

    public void setICommandHandler(ICommandHandler iCommandHandler) {
        this.iCommandHandler = iCommandHandler;
    }
}
