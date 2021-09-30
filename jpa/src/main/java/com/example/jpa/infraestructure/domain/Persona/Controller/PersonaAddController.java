package com.example.jpa.infraestructure.domain.Persona.Controller;

import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Persona.PersonaService;
import com.example.jpa.infraestructure.dto.input.PersonaInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/persona")
public class PersonaAddController {

    @Autowired
    PersonaService personaService;


    @PostMapping
    public PersonaOutputDto añadePersona(@Valid @RequestBody PersonaInputDto personaInputDTO, Errors errors) throws UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Persona no válida");
        }
        return personaService.añadirDto(personaInputDTO);
    }


}