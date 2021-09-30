package com.example.jpa.infraestructure.domain.Persona;

import com.example.jpa.infraestructure.dto.input.PersonaInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import javassist.NotFoundException;

import java.util.List;

public interface PersonaService {

    void añadir(Persona persona);

    PersonaOutputDto añadirDto(PersonaInputDto personaInputDTO);

    void modificar(int id, PersonaInputDto persona) throws NotFoundException;

    void borrar(int id) throws NotFoundException;

    Persona getid(int id) throws NotFoundException;

    List<PersonaOutputDto> getByNombre(String nombre);

    List<PersonaOutputDto> mostrar();


}
