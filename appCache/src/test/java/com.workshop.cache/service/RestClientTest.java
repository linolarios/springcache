package com.workshop.cache.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestClientTest {

    @Autowired
    RestClient restClient;

    @Test
    public void testCacheWhenNeverExpires() {
        assertEquals(3, restClient.getUsersList().size());
    }

    @Test
    public void testGetDBUsers2() {
        assertEquals("Jordan", restClient.getUsersList().get(0).getName());
    }

    @Test
    public void testGetCode() {
        assertEquals("code: ABCDE null", restClient.getCodeWithName(null));
    }


}
