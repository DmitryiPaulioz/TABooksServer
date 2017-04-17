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


    private OutputStream os;

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String version;
    private String statusCode;
    private String server;
    private String date;
    private String contentType;
    private String contentLength;
    private String body;


    public OutputStream getOs() {
        return os;
    }

    public String getVersion() {
        return version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getServer() {
        return server;
    }

    public String getDate() {
        return date;
    }

    public String getContentType() {
        return contentType;
    }

    public String getContentLength() {
        return contentLength;
    }

    public String getBody() {
        return body;
    }

    public ResponseHandler(OutputStream outputStream) {
        this.os = outputStream;
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
