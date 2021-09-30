package com.example.jpa.infraestructure.domain.Profesor.Controller;

import com.example.jpa.infraestructure.domain.Profesor.ProfesorService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class ProfesorDeleteController {

    @Autowired
    ProfesorService profesorService;

    @DeleteMapping("{id}")
    public void deleteProfesor(@PathVariable String id) throws NotFoundException {
        profesorService.borrar(id);
    }


}
