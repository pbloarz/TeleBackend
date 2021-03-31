package com.pbloarz.demo.service;

import java.util.List;

import com.pbloarz.demo.repository.PlanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pbloarz.demo.model.Plan;

import com.pbloarz.demo.response.RespuestaPersonalizada;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PlanService{
    @Autowired
    private PlanDao planDao;
   

    public ResponseEntity<Object> create(Plan usuario){
        ResponseEntity<Object> respuesta;
        try {
            planDao.save(usuario);
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

    public Plan findByPlanCode(String code) {
        return planDao.findByCode(code);
    }
    public Plan findByPlanName(String name){
        return planDao.findByName(name);
    }
    public void edit(@RequestBody Plan user){
        planDao.save(user);
    }
    public void delete(@PathVariable("id") Integer id){
        planDao.deleteById(id);
    }
    public ResponseEntity<Object> list(){
        ResponseEntity<Object> respuesta;
        try {
            List<Plan> plans = planDao.findAll();
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(plans,HttpStatus.OK);
        } catch (Exception e) {
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>("Disculpenos tenemos un error",HttpStatus.BAD_REQUEST);
        }
        return respuesta;
    }

}
