package com.example.jpa.infraestructure.domain.Materia;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.AsignaturaInputDto;
import com.example.jpa.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {
    AsignaturaOutputDto añadirDto(AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    void borrar(String id) throws NotFoundException;

    void modificar(String id, AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    Asignatura getid(String id) throws NotFoundException;

    List<AsignaturaOutputDto> mostrar();
}