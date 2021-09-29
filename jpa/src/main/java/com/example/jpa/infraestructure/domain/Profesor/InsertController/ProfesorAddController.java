package com.example.jpa.infraestructure.domain.Profesor.InsertController;

import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ProfesorOutputDto addProfesor(@Valid @RequestBody ProfesorInputDto p){
        return profesorService.addProfesor(p);
    }
}
