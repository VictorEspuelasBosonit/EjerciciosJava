package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.domain.Persona.Usuario;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.StudentOutputDto;
import com.example.jpa.infraestructure.repository.ProfesorRepositorio;
import com.example.jpa.infraestructure.repository.StudentRepositorio;
import com.example.jpa.infraestructure.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<StudentOutputDto> getAll() {
        List<Student> studentList = studentRepositorio.findAll();
        List<StudentOutputDto> studentOutputDtoList = new ArrayList<>();
        for (Student uaxu : studentList) {
            StudentOutputDto studentOutputDto = new StudentOutputDto();
            studentOutputDto.setNum_hours_week(uaxu.getNum_hours_week());
            studentOutputDto.setComents(uaxu.getComents());
            studentOutputDto.setBranch(uaxu.getBranch());
            studentOutputDtoList.add(studentOutputDto);


        }
        return studentOutputDtoList;
    }

    @Override
    public StudentOutputDto getById(String id_student) throws Exception {
        Student student = studentRepositorio.findById(id_student).orElseThrow(() -> new Exception("No encontrado"));;
        return null;
    }

    @Override
    public StudentOutputDto addStudent(StudentInputDto s) {
        Usuario usuario = usuarioRepositorio.findById(s.getId_usuario()).orElseThrow();
        Profesor profesor = profesorRepositorio.findById(s.getId_profesor()).orElseThrow();
        Student student = new Student(s, usuario, profesor);
        studentRepositorio.saveAndFlush(student);
        StudentOutputDto studentOutputDto = new StudentOutputDto(student);
        return studentOutputDto;
    }

//    @Override
//    public StudentOutputDto updateById(Integer id, StudentInputDto u) throws Exception {
//        return null;
//    }

    public void deleteStudentById(String id_student) {
        studentRepositorio.delete(studentRepositorio.getById(id_student));

    }
}
