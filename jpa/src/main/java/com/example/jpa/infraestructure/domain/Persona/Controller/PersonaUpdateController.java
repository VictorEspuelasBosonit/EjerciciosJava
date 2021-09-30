package com.example.jpa.infraestructure.domain.Persona.Controller;

import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Persona.PersonaService;
import com.example.jpa.infraestructure.dto.input.PersonaInputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/persona")
public class PersonaUpdateController {

    @Autowired
    PersonaService personaService;


    @PutMapping("{id}")
    public void modificaPersona(@PathVariable int id, @Valid @RequestBody PersonaInputDto persona, Errors errors) throws NotFoundException, UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Persona no válida");
        }
        personaService.modificar(id, persona);
    }
}
