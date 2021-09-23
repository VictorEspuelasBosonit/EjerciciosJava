package com.example.jpa.infraestructure.domain;

import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface PersonaService {
    public List<UsuarioOutputDto> getAll();
    public UsuarioOutputDto getById(@PathVariable Integer id) throws Exception;
    public List<UsuarioOutputDto> getByName(@PathVariable String name) throws Exception;
    public UsuarioOutputDto addUsuario(@Valid @RequestBody UsuarioInputDto u);
    public UsuarioOutputDto updateById(@PathVariable("id") Integer id, @Valid @RequestBody UsuarioInputDto u) throws Exception;
    public void deleteUsuarioById(@PathVariable("id") Integer id);





    }
