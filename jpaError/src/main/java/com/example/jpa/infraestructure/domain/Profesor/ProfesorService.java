package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;

import java.util.List;

public interface ProfesorService {

    public ProfesorOutputDto añadirDto (ProfesorInputDto profesorInputDto) throws NotFoundException;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, ProfesorInputDto profesorInputDto) throws NotFoundException ;

    public Profesor getid(String id) throws NotFoundException;
    public List<PersonaOutputDto> mostrar();
    public List<PersonaOutputDto> mostrarSoloPersona();

}
