package com.pbloarz.demo.service;



import com.pbloarz.demo.model.Communication;
import com.pbloarz.demo.repository.CommunicationDao;
import com.pbloarz.demo.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CommunicationService{
    @Autowired
    private CommunicationDao communicationDao;

    public ResponseEntity<Object> create(Communication communication){
        ResponseEntity<Object> respuesta;
        try {
            communicationDao.save(communication);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion usuario Exitosa", HttpStatus.OK);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Error creando usuario", HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
    public void edit(@RequestBody Communication communication){
        communicationDao.save(communication);
    }
    public void delete(@PathVariable("id") Integer id){
        communicationDao.deleteById(id);
    }
    public ResponseEntity<Object> list(){
        ResponseEntity<Object> respuesta;
        try {
            List<Communication> communications =communicationDao.findAll();
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(communications,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }
}
