package com.epam.httpserverwithbooks.assured.tests;

import com.epam.httpserverwithbooks.assured.PreparationSteps;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class GetAllBooksTest extends PreparationSteps {

    @Test
    public void getAllBooksFromJSONTest() {
        Response response =
                given()
                        .contentType(JSON_CONTENT_TYPE)
                .when()
                        .get("/book")
                .thenReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
