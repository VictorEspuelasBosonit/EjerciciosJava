package com.example.jpa.infraestructure.domain.Profesor.Controller;

import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profesor")
public class ProfesorUpdateController {

    @Autowired
    ProfesorService profesorService;


    @PutMapping("{id}")
    public void modificaProfesor(@PathVariable String id, @Valid @RequestBody ProfesorInputDto profesorInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if(errors.hasErrors()){
            throw new UnprocessableException("Profesor no válido");
        }
        profesorService.modificar(id,profesorInputDto);
    }
}
