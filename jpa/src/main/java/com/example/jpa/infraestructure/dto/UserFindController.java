package com.example.jpa.infraestructure.dto;

import com.example.jpa.infraestructure.domain.PersonaService;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class UserFindController {

    @Autowired
    PersonaService personaService;


    @GetMapping
    public List<UsuarioOutputDto> getAll() {
        return personaService.getAll();
    }

    @GetMapping("{id}")
    public UsuarioOutputDto getById(@PathVariable Integer id) throws Exception {
        return personaService.getById(id);
    }

    @GetMapping("name/{name}")
    public List<UsuarioOutputDto> getByName(@PathVariable String name) throws Exception {
        return personaService.getByName(name);
    }
}
