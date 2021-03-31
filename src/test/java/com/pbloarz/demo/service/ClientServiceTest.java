package com.pbloarz.demo.service;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.pbloarz.demo.model.Client;

import org.junit.Before;    
    
public class ClientServiceTest {

    @Autowired
    private Client client;

    @Before
    public void setup(){
        client = new Client();
        client.setFirstName("pablo");
    }
        
    @Test
    public void client_creat_test() {
        setup();
        Assertions.assertEquals("pablo",client.getFirstName());


        
    }
}
    