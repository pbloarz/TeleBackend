package com.pbloarz.demo.controller;

import com.pbloarz.demo.model.Client;
import com.pbloarz.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/client")
public class ClientController {

    @Autowired private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody Client client){
       return clientService.create(client);
    }
    @GetMapping("/list")
    public ResponseEntity<Object> list(){
        return clientService.list();
    }
    @GetMapping("/findClientByRut")
    public Client findClientByRut(String rut){
        return clientService.findClientByRut(rut);
    }
    @GetMapping("/fingClientByFirstname")
    public Client findClientByFirstName(String firtName){
        return clientService.findClientByFirstName(firtName);
    }
    @GetMapping("/findClientBylastname")
    public Client findClientByLastName(String lastName){
        return clientService.findClientByLastName(lastName);
    }
    @GetMapping("/findClietByCellphone")
    public Client findClientByCellphone(String cellphone){
        return clientService.findClientByCellphone(cellphone);
    }
    @GetMapping("/findClienteByDir")
    public Client findClientByDir(String dir){
        return clientService.findClientByDir(dir);
    }

    @GetMapping("/findClientEmail")
    public Client findClientByEmail(String email){
        return clientService.findClientByEmail(email);
    }
    @PutMapping("/edit")
    public void edit(@RequestBody Client client){
        clientService.edit(client);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        clientService.delete(id);
    }


}
