package com.epam.httpserverwithbooks.template.tests;

import com.epam.httpserverwithbooks.template.PreparationSteps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Lenigard on 04.05.2017.
 */
public class DeleteAllBooksTest extends PreparationSteps{
    @Test
    public void deleteAllBooksInJSONAndCheckStatusCodeTest(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(DEFAULT_BOOK_URL);
        ResponseEntity<String> response = restTemplate.getForEntity(DEFAULT_BOOK_URL, String.class);
        Assert.assertTrue(response.getBody().equals(""));
    }

}
