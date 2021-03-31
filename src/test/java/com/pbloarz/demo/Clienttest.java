package com.pbloarz.demo;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;


import com.pbloarz.demo.model.Client;
import com.pbloarz.demo.model.Communication;
import com.pbloarz.demo.model.Plan;
import com.pbloarz.demo.repository.CommunicationDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class Clienttest {

   
    @Autowired
    private CommunicationDao communicationDao = mock(CommunicationDao.class);
    

    void  setup(){
        Client client = new Client();
        client.setId(1);
        client.setCellphone("321822694");
        client.setCity("lorica");
        client.setEmail("pablo@gmail.com");
        client.setFirstName("pablo");
        client.setLastname("romero");
        client.setRut("3343434jf");

        Plan plan = new Plan();
        plan.setName("inff");
        plan.setCode("eedddi3");
        plan.setId(1);
        plan.setCharacteristies("sfsdfsdfsdfdsfdsf");

        Communication communication = new Communication();

        communication.setId(1);
        communication.setCliente(client);
        communication.setPlan(plan);
        List<Communication> librosMock = new ArrayList<>();
        when(communicationDao.findAll()).thenReturn(librosMock);
    }

    @Test
    void create(){
        setup();

    }
}
