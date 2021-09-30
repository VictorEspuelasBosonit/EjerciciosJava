package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    ProfesorOutputDto añadirDto(ProfesorInputDto profesorInputDto) throws NotFoundException;

    void borrar(String id) throws NotFoundException;

    void modificar(String id, ProfesorInputDto profesorInputDto) throws NotFoundException;

    Profesor getid(String id) throws NotFoundException;

    List<PersonaOutputDto> mostrar();

    List<PersonaOutputDto> mostrarSoloPersona();

}
