package com.example.jpa.infraestructure.domain.Materia;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Estudiante.StudentServiceImpl;
import com.example.jpa.infraestructure.dto.input.AsignaturaInputDto;
import com.example.jpa.infraestructure.dto.output.AsignaturaOutputDto;
import com.example.jpa.infraestructure.repository.AsignaturaRepositorio;
import com.example.jpa.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepositorio asignaturaRepositorio;

    @Autowired
    AsignaturaServiceImpl asignaturaService;

    @Autowired
    StudentServiceImpl studentService;

    @Autowired
    StudentRepositorio studentRepositorio;

    public AsignaturaOutputDto añadirDto(AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        List<Student> studentList = new ArrayList<>();
        if (asignaturaInputDto.getId_student() != null) {
            for (String p : asignaturaInputDto.getId_student()) {
                Student student = studentService.getid(p);
                studentList.add(student);
            }
        }
        Asignatura asignatura = new Asignatura(asignaturaInputDto, studentList);

        if (studentList != null) {
            for (Student student : studentList) {
                List<Asignatura> asignaturas = student.getAsignaturas();
                asignaturas.add(asignatura);
                student.setAsignaturas(asignaturas);
            }
        }
        asignaturaRepositorio.save(asignatura);
        AsignaturaOutputDto output = new AsignaturaOutputDto(asignatura);
        return output;
    }


    public void borrar(String id) throws NotFoundException {
        Asignatura asignatura = asignaturaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe un estudiante con ese ID"));
        List<Student> studentList = asignatura.getStudent();
        if (studentList != null) {
            throw new NotFoundException("La asignatura tiene algun estudiante matriculado. No puede ser borrada.");
        } else {
            asignaturaRepositorio.deleteById(id);
        }
    }

    public void modificar(String id, AsignaturaInputDto asignaturaInputDto) throws NotFoundException {
        List<Student> studentList = new ArrayList<>();
        for (String p : asignaturaInputDto.getId_student()) {
            Student student = studentService.getid(p);
            studentList.add(student);
        }
        Asignatura asignatura = asignaturaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una asignatura con ese ID"));
        asignatura.setAsignatura(asignaturaInputDto, studentList);
        asignaturaRepositorio.save(asignatura);
    }

    public Asignatura getid(String id) throws NotFoundException {
        Asignatura asignatura = asignaturaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Asignatura no encontrada"));
        return asignatura;
    }

    public List<AsignaturaOutputDto> mostrar() {
        return asignaturaRepositorio.findAll().stream().map(p -> new AsignaturaOutputDto(p)).collect(Collectors.toList());
    }

}