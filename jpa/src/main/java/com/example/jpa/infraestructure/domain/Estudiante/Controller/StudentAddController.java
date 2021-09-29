package com.example.jpa.infraestructure.domain.Estudiante.Controller;

import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentAddController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public StudentOutputDto addStudent(@Valid @RequestBody StudentInputDto s){
        return studentService.addStudent(s);
    }
}
