package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.dto.UserNotFoundException;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.StudentOutputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public interface StudentService {
    public List<StudentOutputDto> getAll();
    public StudentOutputDto getById(@PathVariable String id) throws Exception;
    public StudentOutputDto addStudent(@Valid @RequestBody StudentInputDto u);
//    public StudentOutputDto updateById(@PathVariable("id") String id, @Valid @RequestBody StudentInputDto u) throws Exception;
    public void deleteStudentById(@PathVariable("id") String id_student);
}
