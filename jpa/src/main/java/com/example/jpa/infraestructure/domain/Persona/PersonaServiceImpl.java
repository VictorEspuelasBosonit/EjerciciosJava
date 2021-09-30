package com.example.jpa.infraestructure.domain.Persona;

import com.example.jpa.infraestructure.Exceptions.NotFoundException;
import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.dto.input.PersonaInputDto;
import com.example.jpa.infraestructure.dto.output.PersonaOutputDto;
import com.example.jpa.infraestructure.repository.PersonaRepositorio;
import com.example.jpa.infraestructure.repository.ProfesorRepositorio;
import com.example.jpa.infraestructure.repository.StudentRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepositorio personaRepositorio;

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Autowired
    StudentRepositorio studentRepositorio;

    public void añadir(Persona persona) {
        System.out.println("Entrando a add Persona");
        personaRepositorio.save(persona);
        System.out.println("hola");
    }

    public PersonaOutputDto añadirDto(PersonaInputDto personaInputDTO) {
        System.out.println("Entrando a add Persona");
        Persona p = new Persona(personaInputDTO);
        personaRepositorio.save(p);
        PersonaOutputDto output = new PersonaOutputDto(p);
        return output;
    }

    public void modificar(int id, PersonaInputDto persona) throws NotFoundException {
        Persona persona1 = personaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        persona1.setPersona(persona);
        personaRepositorio.save(persona1);
    }

    public void borrar(int id) throws NotFoundException {
        Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("No existe una persona con ese ID"));
        Profesor profesor = persona.getProfesor();
        Student student = persona.getStudent();
        if (profesor != null) {
            //profesorRepository.deleteById(profesor.getId_profesor());
            throw new NotFoundException("Esta persona tiene un profesor asignado, no puede ser borrada.");
        } else {
            if (student != null) {
                //studentRepository.deleteById(student.getId_student());
                throw new NotFoundException("Esta persona tiene un estudiante asignado, no puede ser borrada.");
            } else {
                personaRepositorio.delete(persona);
            }
        }
    }

    public Persona getid(int id) throws NotFoundException {
        Persona persona = personaRepositorio.findById(id).orElseThrow(() -> new NotFoundException("Persona no encontrada"));
        return persona;
    }

    public List<PersonaOutputDto> getByNombre(String nombre) {
        return personaRepositorio.findByName(nombre).stream().map(p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }

    public List<PersonaOutputDto> mostrar() {
        return personaRepositorio.findAll().stream().map(p -> new PersonaOutputDto(p)).collect(Collectors.toList());
    }


}