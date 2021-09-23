package com.example.jpa.infraestructure.dto;

import com.example.jpa.infraestructure.domain.PersonaService;
import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class UserUpdateController {

    @Autowired
    PersonaService personaService;

    @PutMapping("{id}")
    public UsuarioOutputDto updateById(@PathVariable("id") Integer id, @Valid @RequestBody UsuarioInputDto u) throws Exception {
        return personaService.updateById(id, u);
    }
}
