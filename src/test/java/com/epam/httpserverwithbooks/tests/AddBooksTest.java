package com.epam.httpserverwithbooks.tests;

import com.epam.httpserver.book.Book;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Dmitryi_Paulioz on 4/23/2017.
 */
public class AddBooksTest extends PreparationSteps {
    @Test
    public void addNewBookAndCheckHisCorrectStatusCodeTest() {
        Book newAddedBook = new Book();
        given()
                .contentType(JSON_CONTENT_TYPE)
                .body(newAddedBook)
        .when()
                .post(DEFAULT_COMMAND_PATH)
        .then()
                .statusCode(201);
    }

    @Test
    public void addNewBookByRequestBodyAndCheckHisCorrectStatusCodeTest(){
        String newBookBody = "{\"title\":\"The Lord of the Rings\",\"authorName\":\"J. R. R. Tolkien\",\"pageCount\":1025,\"yearOfEdition\":1954,\"id\":2}";
        given()
                .contentType(JSON_CONTENT_TYPE)
                .body(newBookBody)
        .when()
                .post(DEFAULT_COMMAND_PATH)
        .then()
                .statusCode(201);
    }
}
