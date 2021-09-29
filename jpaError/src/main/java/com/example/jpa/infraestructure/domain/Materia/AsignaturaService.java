package com.example.jpa.infraestructure.domain.Materia;
import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.dto.input.AsignaturaInputDto;
import com.example.jpa.infraestructure.dto.output.AsignaturaOutputDto;

import java.util.List;

public interface AsignaturaService {
    public AsignaturaOutputDto añadirDto (AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    public void borrar(String id) throws NotFoundException;

    public void modificar (String id, AsignaturaInputDto asignaturaInputDto) throws NotFoundException;

    public Asignatura getid(String id) throws NotFoundException;

    public List<AsignaturaOutputDto> mostrar();
}