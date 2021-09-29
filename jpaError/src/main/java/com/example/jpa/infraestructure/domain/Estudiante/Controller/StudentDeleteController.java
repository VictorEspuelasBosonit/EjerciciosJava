package com.example.jpa.infraestructure.domain.Estudiante.Controller;

import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estudiante")
public class StudentDeleteController {

    @Autowired
    StudentService studentService;

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable String id) throws NotFoundException {
        studentService.borrar(id);
    }


}