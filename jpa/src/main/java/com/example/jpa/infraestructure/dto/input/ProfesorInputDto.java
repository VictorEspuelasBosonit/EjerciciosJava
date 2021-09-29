package com.example.jpa.infraestructure.dto.input;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Persona.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProfesorInputDto {
    Usuario usuario;
    String coments;
    String branch;
    List<Student> students = new ArrayList<>();
}
