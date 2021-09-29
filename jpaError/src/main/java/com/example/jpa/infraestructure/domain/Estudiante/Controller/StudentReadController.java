package com.example.jpa.infraestructure.domain.Estudiante.Controller;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Estudiante.StudentService;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.StudentPersonaOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
public class StudentReadController {

    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public PersonaOutputDto getId(@PathVariable String id, @RequestParam(name = "soloPersona",  defaultValue = "false") String outputType) throws NotFoundException {
        Student student = studentService.getid(id);
        if (outputType.equals("true") ) {
            return new PersonaOutputDto(student.getPersona());
        } else {
            return new StudentPersonaOutputDto(student);
        }
    }



    @GetMapping
    public List<PersonaOutputDto> mostrarTodos(@RequestParam(name = "soloPersona",  defaultValue = "false") String outputType)
    {
        if (outputType.equals("true") ) {
            return studentService.mostrarSoloPersona();
        } else {
            return studentService.mostrar();
        }

    }
}
