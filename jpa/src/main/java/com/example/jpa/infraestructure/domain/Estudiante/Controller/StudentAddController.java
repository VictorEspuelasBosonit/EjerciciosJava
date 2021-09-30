package com.example.jpa.infraestructure.domain.Estudiante.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.Exceptions.UnprocessableException;
import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.StudentPersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/estudiante")
public class StudentAddController {

    @Autowired
    StudentService studentService;


    @PostMapping
    public StudentPersonaOutputDto añadeStudent(@Valid @RequestBody StudentInputDto studentInputDto, Errors errors) throws NotFoundException, UnprocessableException {
        if (errors.hasErrors()) {
            throw new UnprocessableException("Estudiante no válido");
        }
        return studentService.añadirDto(studentInputDto);
    }


}
