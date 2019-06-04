package com.mkdk.app.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String uri;

    @Before
    public void init(){
        String server = "http://localhost";
        uri = server.concat(":").concat(Integer.toString(port));
    }

    @Test
    public void deveRetonarListadeBooks(){
        String endpoint = uri.concat("/book/listar");
        List ret = testRestTemplate.getForObject(endpoint, List.class);

        Assert.assertEquals(5, ret.size());
    }
}
