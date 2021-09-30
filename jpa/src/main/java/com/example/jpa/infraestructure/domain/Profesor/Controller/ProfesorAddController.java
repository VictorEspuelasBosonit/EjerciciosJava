package com.example.jpa.infraestructure.domain.Profesor.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorAddController {

    @Autowired
    ProfesorService profesorService;


    @PostMapping("")
    public ProfesorOutputDto añadeProfesor(@Valid @RequestBody ProfesorInputDto profesorInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Profesor no válido");
        }
        return profesorService.añadirDto(profesorInputDto);
    }


}
