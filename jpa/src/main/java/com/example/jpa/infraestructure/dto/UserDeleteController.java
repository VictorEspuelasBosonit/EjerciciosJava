package com.example.jpa.infraestructure.dto;

import com.example.jpa.infraestructure.domain.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserDeleteController {

    @Autowired
    PersonaService personaService;

    @DeleteMapping("{id}")
    public void deleteUsuarioById(@PathVariable("id") Integer id) {
        personaService.deleteUsuarioById(id);
    }
}
