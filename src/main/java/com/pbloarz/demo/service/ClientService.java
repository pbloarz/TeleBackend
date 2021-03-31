package com.pbloarz.demo.service;

import com.pbloarz.demo.model.Client;
import com.pbloarz.demo.repository.ClientDao;
import com.pbloarz.demo.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;


    public ResponseEntity<Object> create(@RequestBody Client client){
        ResponseEntity<Object> respuesta;
        try {
            clientDao.save(client);
            RespuestaPersonalizada res = new RespuestaPersonalizada("CREACION CON EXITO", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

    public ResponseEntity<Object> list(){
        ResponseEntity<Object> respuesta;
        try {
            List<Client> libros = clientDao.findAll();
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(libros,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public Client findClientByRut(String rut){
        return findClientByRut(rut);
    }
    public Client findClientByFirstName(String firtName){
        return findClientByRut(firtName);
    }
    public Client findClientByLastName(String lastName){
        return findClientByRut(lastName);
    }
    public Client findClientByCellphone(String cellphone){
        return findClientByRut(cellphone);
    }
    public Client findClientByDir(String dir){
        return findClientByRut(dir);
    }
    public Client findClientByEmail(String email){
        return findClientByRut(email);
    }
    public void edit(@RequestBody Client client){
        clientDao.save(client);
    }
    public void delete(@PathVariable("id") Integer id){
        clientDao.deleteById(id);
    }
    public void crear(@RequestBody Client client){
        clientDao.save(client);
    }

}
