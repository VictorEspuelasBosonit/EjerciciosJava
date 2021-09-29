package com.example.jpa.infraestructure.domain.Materia.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Materia.AsignaturaService;
import com.example.jpa.infraestructure.dto.input.AsignaturaInputDto;
import com.example.jpa.infraestructure.dto.output.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaAddController {

    @Autowired
    AsignaturaService asignaturaService;


    @PostMapping("/hola")
    public AsignaturaOutputDto añadeAsignatura(@RequestBody AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        return asignaturaService.añadirDto(asignaturaInputDto);
    }


}

