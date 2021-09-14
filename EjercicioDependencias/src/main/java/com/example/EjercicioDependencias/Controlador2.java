package com.example.EjercicioDependencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controlador2 {

@Autowired
Persona p;

    @GetMapping("/userget")
    public Persona getPersona()
    {
        p.setEdad(p.getEdad()*2);
        return p;
    }

}
