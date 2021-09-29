package com.example.jpa.infraestructure.domain.Persona.Controller;

import com.example.jpa.infraestructure.domain.Persona.PersonaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaDeleteController {

    @Autowired
    PersonaService personaService;


    @DeleteMapping("{id}")
    public void borraPersona(@PathVariable Integer id) throws NotFoundException {
        personaService.borrar(id);
    }


}

