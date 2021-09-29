package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Persona.Persona;
import com.example.jpa.infraestructure.domain.Persona.PersonaServiceImpl;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import com.example.jpa.infraestructure.repository.ProfesorRepositorio;
import com.example.jpa.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    PersonaServiceImpl personaService;

    @Autowired
    StudentRepositorio studentRepositorio;

    @Override
    public ProfesorOutputDto añadirDto (ProfesorInputDto profesorInputDto) throws NotFoundException {
        Persona persona= personaService.getid(profesorInputDto.getId_persona());
        Profesor profesor = new Profesor(profesorInputDto, persona);
        List<Student> studentList = studentRepositorio.findAll().stream().collect(Collectors.toList());
        for (Student s:
                studentList) {
            if(s.getPersona().getId_persona()==profesorInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un estudiante");
            }

        }

        List<Profesor> profesorList = profesorRepositorio.findAll().stream().collect(Collectors.toList());
        for (Profesor p:
                profesorList) {
            if(p.getPersona().getId_persona()==profesorInputDto.getId_persona()){
                throw new NotFoundException("Esa persona ya es un profesor");
            }

        }
        persona.setProfesor(profesor);
        profesorRepositorio.save(profesor);
        ProfesorOutputDto output = new ProfesorOutputDto(persona);
        return output;
    }

    public void borrar(String id) throws NotFoundException {
        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe un profesor con ese ID"));
        Persona persona = profesor.getPersona();
        List<Student> studentList = profesor.getStudentList();

        if(studentList!=null){
            throw new NotFoundException("El profesor tiene estudiantes asingados. No puede ser borrado.");
        }else{
            if(persona!=null){
                throw new NotFoundException("El profesor tiene una persona asignada. No puede ser borrado");
            }else{
                profesorRepositorio.deleteById(id);
            }
        }
    }

    public void modificar (String id, ProfesorInputDto profesorInputDto) throws NotFoundException {
        Profesor profesor= profesorRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Persona persona= personaService.getid(profesorInputDto.getId_persona());
        profesor.setProfesor(profesorInputDto, persona);
        profesorRepositorio.save(profesor);
    }

    public Profesor getid(String id) throws NotFoundException {
        Profesor profesor = profesorRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe un profesor con ese ID"));
        return profesor;
    }
    public List<PersonaOutputDto> mostrarSoloPersona(){
        return profesorRepositorio.findAll().stream().map( p -> new PersonaOutputDto(p.getPersona())).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar(){
        return profesorRepositorio.findAll().stream().map( p -> new ProfesorOutputDto(p.getPersona())).collect(Collectors.toList());
    }

}