package com.epam.httpserverwithbooks.assured.tests;

import com.epam.httpserverwithbooks.assured.PreparationSteps;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class DeleteBooksTest extends PreparationSteps {
    @Test
    public void deleteAllBooksTest() {
        given()
                .contentType(JSON_CONTENT_TYPE)
        .when()
                .delete(DEFAULT_COMMAND_PATH)
        .then()
                .statusCode(200);
    }
}
