package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.StudentPersonaOutputDto;
import java.util.List;

public interface StudentService {
    public StudentPersonaOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException;

    public Student getid(String id) throws NotFoundException ;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException;

    public List<PersonaOutputDto> mostrar();

    public List<PersonaOutputDto> mostrarSoloPersona();

    public void añadirAsignatura(String id,List<String> id_asignatura);

    public void eliminarAsignatura(String id,List<String> id_asignatura) throws NotFoundException;
}

