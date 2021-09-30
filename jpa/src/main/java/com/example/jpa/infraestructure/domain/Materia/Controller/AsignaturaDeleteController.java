package com.example.jpa.infraestructure.domain.Materia.Controller;


import com.example.jpa.infraestructure.domain.Materia.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaDeleteController {

    @Autowired
    AsignaturaService asignaturaService;

    @DeleteMapping("{id}")
    public void deleteAsignatura(@PathVariable String id) {
        asignaturaService.borrar(id);
    }
}
