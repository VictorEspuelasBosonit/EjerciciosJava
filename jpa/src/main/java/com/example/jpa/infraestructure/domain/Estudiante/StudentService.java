package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.StudentPersonaOutputDto;

import java.util.List;

public interface StudentService {
    StudentPersonaOutputDto añadirDto(StudentInputDto studentInputDto) throws NotFoundException;

    Student getid(String id) throws NotFoundException;

    void borrar(String id) throws NotFoundException;

    void modificar(String id, StudentInputDto studentInputDto) throws NotFoundException;

    List<PersonaOutputDto> mostrar();

    List<PersonaOutputDto> mostrarSoloPersona();

    void añadirAsignatura(String id, List<String> id_asignatura);

    void eliminarAsignatura(String id, List<String> id_asignatura) throws NotFoundException;
}

