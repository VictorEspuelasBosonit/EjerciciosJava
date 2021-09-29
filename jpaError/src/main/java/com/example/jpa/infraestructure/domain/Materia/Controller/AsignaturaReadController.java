package com.example.jpa.infraestructure.domain.Materia.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Materia.Asignatura;
import com.example.jpa.infraestructure.domain.Materia.AsignaturaService;
import com.example.jpa.infraestructure.dto.output.AsignaturaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaReadController {
     @Autowired
    AsignaturaService asignaturaService;

    @GetMapping("{id}")
    public AsignaturaOutputDto getId(@PathVariable String id, @RequestParam(name = "outputType",  defaultValue = "simple") String outputType) throws NotFoundException {
        Asignatura asignatura = asignaturaService.getid(id);
        if (outputType.equals("full") ) {
            return new AsignaturaOutputDto(asignatura);
        } else {
            return new AsignaturaOutputDto(asignatura);
        }
    }


    @GetMapping("")
    public List<AsignaturaOutputDto> mostrarTodos()
    {
        return asignaturaService.mostrar();
    }
}