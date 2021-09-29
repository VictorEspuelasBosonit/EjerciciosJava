package com.example.jpa.infraestructure.dto.output;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Persona.Usuario;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentOutputDto {
    String id_student;
    Integer usuario;
    String profesor;
    int num_hours_week;
    String coments;
    String branch;

    public StudentOutputDto(Student s) {
        this.usuario = s.getUsuario().getId_persona();
        this.id_student = s.getId_student();
        this.profesor = s.getProfesor().getId_profesor();
        this.num_hours_week = s.getNum_hours_week();
        this.coments = s.getComents();
        this.branch = s.getBranch();
    }
}
