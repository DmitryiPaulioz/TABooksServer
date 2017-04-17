package com.epam.httpserver.handler;

import com.epam.httpserver.resources.CommonConstants;
import com.epam.httpserver.resources.ResponseConstants;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Dmitryi_Paulioz on 4/17/2017.
 */
public class ResponseHandler {


    private String version;
    private String statusCode;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String server;
    private String date;
    private String contentType;
    private String contentLength;
    private String body;

    private OutputStream os;


    public ResponseHandler(OutputStream outputStream) {
        this.os = outputStream;
    }

    public static void createResponse(ResponseHandler responce, RequestHandler request) {

        String body = "";
        responce.setVersion(request.getVersion());
        responce.setContentLength(String.valueOf(body.getBytes().length));
        responce.setBody(body);
        responce.setContentType(request.getContentType());

        try {
            responce.write();
            System.out.println(responce);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write() throws IOException {
        String response = "";
        Map<String, String> responseMap = new LinkedHashMap<String, String>();

        responseMap.put(version, statusCode);

        responseMap.put(ResponseConstants.SERVER, ResponseConstants.SERVER_VALUE);

        if (!contentLength.isEmpty()) {
            responseMap.put(CommonConstants.CONTENT_TYPE, contentType + "\r\n");
        }

        if (!contentLength.isEmpty()) {
            responseMap.put(CommonConstants.CONTENT_LENGTH, contentLength + "\r\n");
        }

        responseMap.put(CommonConstants.CONNECTION, ResponseConstants.CONNECTION_VALUE);

        if (!body.isEmpty()) {
            responseMap.put(ResponseConstants.BODY, body);
        }

        for (Map.Entry<String, String> pair : responseMap.entrySet()) {
            String key = pair.getKey();
            String value = pair.getValue();
            if (key.equals(ResponseConstants.BODY)) {
                response += value;
            } else
                response += key + value;
        }
        os.write(response.getBytes());
    }

}
