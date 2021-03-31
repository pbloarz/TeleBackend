package com.pbloarz.demo;

import com.pbloarz.demo.model.Plan;
import com.pbloarz.demo.model.Usuario;
import com.pbloarz.demo.repository.PlanDao;
import com.pbloarz.demo.repository.UsuarioDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootTest
class TelecomunicacionesApplicationTests {


    @Autowired
    private UsuarioDao dao;
    @Autowired
    private PlanDao planDao;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;



    @Test
    void crearUsuarioTest() {
        Usuario us = new Usuario();
        us.setNombre("romerome");
        us.setId(1);
        us.setClave(passwordEncoder.encode("1234"));
        us.setRol("ADMIN");
        Usuario retorno = dao.save(us);
        assert (retorno.getClave().equalsIgnoreCase(us.getClave()));
    }
    @Test
    void editPlant(){
        Plan plan = new Plan();
        plan.setId(1);
        plan.setCharacteristies("Incluye internet de 500 Mbps y 500 canales");
        plan.setCode("TVIT-4040");
        plan.setPrice(500000);
        plan.setName("Conexion Total");
        planDao.save(plan);
        assert (plan.getCharacteristies().equals("Incluye internet de 500 Mbps y 500 canales"));




    }

}
