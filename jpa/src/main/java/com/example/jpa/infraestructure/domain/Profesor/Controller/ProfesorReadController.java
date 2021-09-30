package com.example.jpa.infraestructure.domain.Profesor.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorReadController {

    @Autowired
    ProfesorService profesorService;


    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable String id, @RequestParam(name = "soloPersona", defaultValue = "false") String outputType) throws NotFoundException {
        Profesor profesor = profesorService.getid(id);
        if (outputType.equals("true")) {
            return new PersonaOutputDto(profesor.getPersona());
        } else {
            return new ProfesorOutputDto(profesor.getPersona());
        }
    }


    @GetMapping("")
    public List<PersonaOutputDto> mostrarTodos(@RequestParam(name = "soloPersona", defaultValue = "false") String outputType) {
        if (outputType.equals("true")) {
            return profesorService.mostrarSoloPersona();
        } else {
            return profesorService.mostrar();
        }
    }

}