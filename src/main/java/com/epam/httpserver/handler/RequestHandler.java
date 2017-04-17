package com.epam.httpserver.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import com.epam.httpserver.resources.CommonConstants;
import com.epam.httpserver.util.HttpMethodUtils;
import com.epam.httpserver.util.SplitUtils;


public class RequestHandler {

    private String method;
    private String path;
    private String version;
    private String host;
    private String connection;
    private String csp;
    private String cacheControl;
    private String userAgent;
    private String accept;
    private String acceptEncoding;
    private String acceptLanguage;
    private String origin;
    private String contentType;
    private String body;
    private int contentLenght = 0;

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getVersion() {
        return version;
    }

    public String getHost() {
        return host;
    }

    public String getConnection() {
        return connection;
    }

    public String getCsp() {
        return csp;
    }

    public String getCacheControl() {
        return cacheControl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getAccept() {
        return accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public String getAcceptLanguage() {
        return acceptLanguage;
    }

    public String getOrigin() {
        return origin;
    }

    public String getContentType() {
        return contentType;
    }

    public String getBody() {
        return body;
    }

    public int getContentLenght() {
        return contentLenght;
    }


    public RequestHandler(BufferedReader bfr) {
        parseRequest(bfr);
    }

    private void parseRequest(BufferedReader bfr) {
        List<String> headerValue = null;
        try {
            headerValue = HttpMethodUtils.getHeaderValue(bfr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String value : headerValue) {
            if (value.startsWith(CommonConstants.GET)) {

                method = CommonConstants.GET;
                path = SplitUtils.getCertainSplitValueBy(value, CommonConstants.PATH, CommonConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VERSION, CommonConstants.SPACE);

            } else if (value.startsWith(CommonConstants.POST)) {

                method = CommonConstants.POST;
                path = SplitUtils.getCertainSplitValueBy(value, CommonConstants.PATH, CommonConstants.SPACE);
                version = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VERSION, CommonConstants.SPACE);

            } else if (value.startsWith(CommonConstants.HOST)) {

                host = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.CONNECTION)) {

                connection = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.CSP)) {

                csp = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.CACHE_CONTROL)) {

                cacheControl = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.USER_AGENT)) {

                userAgent = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.ACCEPT)) {

                accept = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.ACCEPT_ENCODING)) {

                acceptEncoding = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.ACCEPT_LANGUAGE)) {

                acceptLanguage = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.CONTENT_LENGTH)) {

                contentLenght = Integer.parseInt(SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE,
                        CommonConstants.COLON_SPLITTER));

            } else if (value.startsWith(CommonConstants.ORIGIN)) {

                origin = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);

            } else if (value.startsWith(CommonConstants.CONTENT_TYPE)) {

                contentType = SplitUtils.getCertainSplitValueBy(value, CommonConstants.VALUE, CommonConstants.COLON_SPLITTER);
            }
        }

        if (contentLenght > 0) {
            body = headerValue.get(headerValue.size() - 1);
        }

    }

}
