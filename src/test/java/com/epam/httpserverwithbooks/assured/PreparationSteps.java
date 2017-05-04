package com.epam.httpserverwithbooks.assured;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class PreparationSteps {


    protected final String JSON_CONTENT_TYPE = "application/json";
    protected final String DEFAULT_COMMAND_PATH = "/book";
    private final String DEFAULT_PATH = "/test/";
    private final String DEFAULT_PORT = "8181";
    private final String DEFAULT_HOST = "http://localhost";


    @BeforeClass
    public void setRestAssuredUp() {
        String port = System.getProperty("server.port");
        String basePath = System.getProperty("server,base");
        String baseHost = System.getProperty("server.host");
        if (port == null) {
            port = DEFAULT_PORT;
        }
        if (basePath == null) {
            basePath = DEFAULT_PATH;
        }
        if (baseHost == null) {
            baseHost = DEFAULT_HOST;
        }
        RestAssured.port = Integer.valueOf(port);
        RestAssured.basePath = basePath;
        RestAssured.baseURI = baseHost;
/*
        System.out.println(RestAssured.port);
        System.out.println(RestAssured.baseURI);
        System.out.println(RestAssured.basePath);*/
    }

}