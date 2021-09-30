package com.example.jpa.infraestructure.domain.Materia.Controller;

import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Materia.AsignaturaService;
import com.example.jpa.infraestructure.dto.input.AsignaturaInputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaUpdateController {

    @Autowired
    AsignaturaService asignaturaService;


    @PutMapping("{id}")
    public void modificaAsignatura(@PathVariable String id, @Valid @RequestBody AsignaturaInputDto asignaturaInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Asignatura no válida");
        }
        asignaturaService.modificar(id, asignaturaInputDto);
    }


}
