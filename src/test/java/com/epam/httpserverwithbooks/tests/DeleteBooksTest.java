package com.epam.httpserverwithbooks.tests;

import com.epam.httpserver.book.Book;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class DeleteBooksTest extends PreparationSteps {
    @Test
    public void deleteAllBooksTest() {
        Response response =
                given()
                        .contentType(JSON_CONTENT_TYPE)
                .when()
                        .delete(DEFAULT_COMMAND_PATH)
                .thenReturn();
    }
}
