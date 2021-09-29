package com.example.jpa.infraestructure.dto.output;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Materia.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsignaturaOutputDto {

    String id_asignatura;
    List<String> student;
    String asignatura;
    String comments;
    Date initial_date;
    Date finish_date;

    public AsignaturaOutputDto(Asignatura asignatura) {
        if (asignatura == null) {
            return;
        }
        List<String> stringList = new ArrayList<>();
        if(asignatura.getStudent()!=null) {
            for (Student p :
                    asignatura.getStudent()) {
                stringList.add(p.getId_student());
            }
        }
        this.setStudent(stringList);
        this.setId_asignatura(asignatura.getId_asignatura());
        this.setAsignatura(asignatura.getAsignatura());
        this.setComments(asignatura.getComments());
        this.setInitial_date(asignatura.getInitial_date());
        this.setFinish_date(asignatura.getFinish_date());
    }

}