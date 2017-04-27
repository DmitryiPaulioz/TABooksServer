package com.epam.httpserverwithbooks.tests;

import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;


import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class GetAllBooksTest extends PreparationSteps{

    @Test
    public void getAllBooksFromJSONTest() {
        Response rp =
                given()
                        .contentType(JSON_CONTENT_TYPE)
                .when()
                        .get("/book")
                .thenReturn();
    }
}
