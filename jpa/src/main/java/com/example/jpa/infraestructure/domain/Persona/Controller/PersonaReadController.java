package com.example.jpa.infraestructure.domain.Persona.Controller;

import com.example.jpa.infraestructure.domain.Persona.Persona;
import com.example.jpa.infraestructure.domain.Persona.PersonaService;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaReadController {

    @Autowired
    PersonaService personaService;


    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable Integer id) throws NotFoundException {
        Persona persona = personaService.getid(id);
        return new PersonaOutputDto(persona);
    }

    @GetMapping("/nombre/{nombre}")
    public List<PersonaOutputDto> putPersona(@PathVariable String nombre) {
        return personaService.getByNombre(nombre);
    }

    @GetMapping("")
    public List<PersonaOutputDto> mostrarTodos() {
        return personaService.mostrar();
    }
}
