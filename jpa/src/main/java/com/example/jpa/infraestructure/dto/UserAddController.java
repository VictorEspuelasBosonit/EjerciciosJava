package com.example.jpa.infraestructure.dto;

import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import com.example.jpa.infraestructure.domain.Persona.PersonaService;
import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import com.example.jpa.infraestructure.dto.output.StudentOutputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UserAddController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public UsuarioOutputDto addUsuario(@Valid @RequestBody UsuarioInputDto u) {
        return personaService.addUsuario(u);
    }

}
