package com.example.jpa.infraestructure.domain.Estudiante.Controller;

import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class StudentUpdateController {

    @Autowired
    StudentService studentService;


    @PutMapping("{id}")
    public void modificaStudent(@PathVariable String id, @Valid @RequestBody StudentInputDto studentInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Estudiante no válida");
        }
        studentService.modificar(id, studentInputDto);
    }

    @PutMapping("/asignaturas/{id}")
    public void añadirAsignaturas(@PathVariable String id, @RequestHeader List<String> id_asignatura) throws NotFoundException, UnprocessableException {
        studentService.añadirAsignatura(id, id_asignatura);
    }

    @PutMapping("/eliminarAsignaturas/{id}")
    public void eliminarAsignaturas(@PathVariable String id, @RequestHeader List<String> id_asignatura) throws NotFoundException, UnprocessableException {
        studentService.eliminarAsignatura(id, id_asignatura);
    }
}