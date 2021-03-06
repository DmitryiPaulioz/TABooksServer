package com.epam.httpserverwithbooks.template.tests;

import com.epam.httpserverwithbooks.template.PreparationSteps;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.Assert;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.Test;

/**
 * Created by Dmitryi_Paulioz on 5/4/2017.
 */
public class GetBooksTest extends PreparationSteps {

    @Test
    public void getAllBooksFromJSONAndCheckStatusCodeIsSuccessfulTest() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(DEFAULT_BOOK_URL, String.class);
        HttpStatus statusCodeHandler = response.getStatusCode();
        Assert.assertTrue(statusCodeHandler.is2xxSuccessful());
    }


}

