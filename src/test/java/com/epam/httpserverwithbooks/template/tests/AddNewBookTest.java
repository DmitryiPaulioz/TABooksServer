package com.epam.httpserverwithbooks.template.tests;

import com.epam.httpserver.book.Book;
import com.epam.httpserverwithbooks.template.PreparationSteps;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.URI;

/**
 * Created by Lenigard on 04.05.2017.
 */
public class AddNewBookTest extends PreparationSteps {

    @Test
    public void addNewBookToJSONAndCheckStatusCodeTest(){
        RestTemplate restTemplate = new RestTemplate();
        Book newBook = new Book();
        HttpEntity<Book> request = new HttpEntity<Book>(newBook, new HttpHeaders());
        Book bookForCheck = null;
        bookForCheck = restTemplate.postForObject(DEFAULT_BOOK_URL, request, Book.class);
        Assert.assertEquals(bookForCheck, null);
    }
}
