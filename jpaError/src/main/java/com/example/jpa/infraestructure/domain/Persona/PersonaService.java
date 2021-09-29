package com.example.jpa.infraestructure.domain.Persona;

import com.example.jpa.infraestructure.dto.input.PersonaInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import javassist.NotFoundException;

import java.util.List;

public interface PersonaService {

    public void añadir (Persona persona);

    public PersonaOutputDto añadirDto (PersonaInputDto personaInputDTO);

    public void modificar (int id, PersonaInputDto persona) throws NotFoundException;

    public void borrar(int id) throws NotFoundException;

    public Persona getid(int id) throws NotFoundException;

    public List<PersonaOutputDto> getByNombre(String nombre);

    public List<PersonaOutputDto> mostrar();


}
