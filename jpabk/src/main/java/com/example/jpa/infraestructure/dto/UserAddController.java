package com.example.jpa.infraestructure.dto;

import com.example.jpa.infraestructure.domain.PersonaService;
import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class UserAddController {

    @Autowired
    PersonaService personaService;

    @PostMapping
    public UsuarioOutputDto addUsuario(@Valid @RequestBody UsuarioInputDto u) {
        return personaService.addUsuario(u);
    }

}
