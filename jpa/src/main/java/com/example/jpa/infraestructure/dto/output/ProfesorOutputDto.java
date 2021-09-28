package com.example.jpa.infraestructure.dto.output;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Persona.Usuario;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfesorOutputDto {
    String id_profesor;
    Usuario id_usuario;
    String coments;
    String branch;
    List<Student> students = new ArrayList<>();

    public ProfesorOutputDto(Profesor profesor){
        this.id_profesor = profesor.getId_profesor();
        this.id_usuario = new Usuario();
        this.coments = profesor.getComents();
        this.branch = profesor.getBranch();
        this.students = new ArrayList<>();

    }

}