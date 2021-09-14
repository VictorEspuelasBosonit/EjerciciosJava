package com.example.EjercicioDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador1 {

    @Autowired
    Persona p;

    @GetMapping("/useradd")
    public Persona recibePersona(@RequestHeader("nombre") String nombreP, @RequestHeader("poblacion") String poblacion, @RequestHeader("edad") Integer edad)
    {
        if(poblacion ==null){
            poblacion ="";
        }
        if (edad==null){
            edad=0;
        }

        p.setNombre(nombreP);
        p.setPoblacion(poblacion);
        p.setEdad(edad+1);
        return p;
    }

}
