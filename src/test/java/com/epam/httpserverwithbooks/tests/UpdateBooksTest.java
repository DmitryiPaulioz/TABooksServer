package com.epam.httpserverwithbooks.tests;

import com.epam.httpserver.book.Book;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class UpdateBooksTest extends PreparationSteps {
    @Test
    public void addAndThenUpdateBookInfoAndReturnItToJSONTest(){
        Book newAddedBook = new Book();
        Response response =
                given()
                        .contentType(JSON_CONTENT_TYPE)
                        .body(newAddedBook)
                .when()
                        .post(DEFAULT_COMMAND_PATH)
                .thenReturn();
        newAddedBook.setId(newAddedBook.getId() + 1);
        response =
                given()
                .contentType(JSON_CONTENT_TYPE)
                .body(newAddedBook)
        .when()
                .put(DEFAULT_COMMAND_PATH)
        .thenReturn();
    }
}
