package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Materia.Asignatura;
import com.example.jpa.infraestructure.domain.Materia.AsignaturaServiceImpl;
import com.example.jpa.infraestructure.domain.Persona.Persona;
import com.example.jpa.infraestructure.domain.Persona.PersonaServiceImpl;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.domain.Profesor.ProfesorServiceImpl;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.StudentPersonaOutputDto;
import com.example.jpa.infraestructure.repository.AsignaturaRepositorio;
import com.example.jpa.infraestructure.repository.ProfesorRepositorio;
import com.example.jpa.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepositorio studentRepositorio;

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    ProfesorServiceImpl profesorService;

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    AsignaturaRepositorio asignaturaRepositorio;

    @Autowired
    AsignaturaServiceImpl asignaturaService;

    public StudentPersonaOutputDto añadirDto (StudentInputDto studentInputDto) throws NotFoundException {
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        List<Asignatura> asignaturaList = new ArrayList<>();
        if(studentInputDto.getAsignaturas()!= null){
            for (String a:
                    studentInputDto.getAsignaturas()) {
                asignaturaList.add(asignaturaService.getid(a));
            }
        }

        Student student = new Student(studentInputDto, persona, profesor, asignaturaList);

        List<Student> studentList = studentRepositorio.findAll().stream().collect(Collectors.toList());
        for (Student s:
                studentList) {
            if(s.getPersona().getId_persona()==studentInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un estudiante");
            }

        }

        List<Profesor> profesorList = profesorRepositorio.findAll().stream().collect(Collectors.toList());
        for (Profesor p:
                profesorList) {
            if(p.getPersona().getId_persona()==studentInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un profesor");
            }

        }
        persona.setStudent(student);
        studentRepositorio.save(student);
        StudentPersonaOutputDto output = new StudentPersonaOutputDto(student);
        return output;
    }




    public void borrar(String id) throws NotFoundException {
        Student student= studentRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe un estudiante con ese ID"));
        Profesor profesor = student.getProfesor();
        Persona persona = student.getPersona();
        List<Asignatura> asignaturas = student.getAsignaturas();

        if(profesor!=null){
            throw new NotFoundException("El estudiante tiene un profesor asignado. No puede ser borrado.");
        }else{
            if(persona!=null){
                throw new NotFoundException("El estudiante tiene una persona asignado. No puede ser borrado.");
            }else{
                if(asignaturas!=null){
                    throw new NotFoundException("El estudiante tiene alguna asignatura asignada. No puede ser borrado.");
                }else{
                    studentRepositorio.deleteById(id);
                }
            }
        }


    }



    public Student getid(String id) throws NotFoundException {
        Student student = studentRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Estudiante no encontrado"));
        return student;
    }
    public List<PersonaOutputDto> mostrarSoloPersona(){
        return studentRepositorio.findAll().stream().map( p -> new PersonaOutputDto(p.getPersona())).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return studentRepositorio.findAll().stream().map( p -> new StudentPersonaOutputDto(p)).collect(Collectors.toList());
    }

    public void modificar (String id, StudentInputDto studentInputDto) throws NotFoundException {
        Student student= studentRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Persona persona= personaService.getid(studentInputDto.getId_persona());
        Profesor profesor = profesorService.getid(studentInputDto.getId_profesor());
        List<Asignatura> asignaturaList = new ArrayList<>();
        for (String a:
                studentInputDto.getAsignaturas()) {
            asignaturaList.add(asignaturaService.getid(a));
        }
        student.setStudent(studentInputDto, persona, profesor, asignaturaList);
        studentRepositorio.save(student);
    }

    public void añadirAsignatura(String id,List<String> id_asignatura) throws NotFoundException{
        Student student= studentRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        List<Asignatura> asignaturas = student.getAsignaturas();
        for (String a:
                id_asignatura) {
            Asignatura asignatura = asignaturaRepositorio.findById(a).orElseThrow(() -> new NotFoundException("Una de las asignaturas introducidas no existe"));
            asignaturas.add(asignatura);
            asignatura.getStudent().add(student);
            asignaturaRepositorio.save(asignatura);
        }
        student.setAsignaturas(asignaturas);
        studentRepositorio.save(student);
    }

    public void eliminarAsignatura(String id,List<String> id_asignatura) throws NotFoundException{
        Student student= studentRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        List<Asignatura> asignaturas = student.getAsignaturas();
        for (String a:
                id_asignatura) {
            Asignatura asignatura = asignaturaRepositorio.findById(a).orElseThrow(() -> new NotFoundException("Una de las asignaturas introducidas no existe"));
            asignaturas.remove(asignatura);
            asignatura.getStudent().remove(student);
            asignaturaRepositorio.save(asignatura);
        }
        student.setAsignaturas(asignaturas);
        studentRepositorio.save(student);
    }
}
