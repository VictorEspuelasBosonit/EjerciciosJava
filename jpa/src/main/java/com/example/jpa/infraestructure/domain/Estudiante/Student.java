package com.example.jpa.infraestructure.domain.Estudiante;

import com.example.jpa.infraestructure.domain.Persona.Usuario;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.dto.input.StudentInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "Student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id_student;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_persona")
    Usuario usuario;

    @Column(nullable = false)
    int num_hours_week;

    @Column(nullable = false)
    String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;

    @Column(nullable = false)
    String branch;

//    @ManyToMany( cascade = CascadeType.ALL, mappedBy = "students")
//    Set<StudentMatter> studentMatters;

    public Student(StudentInputDto studentInputDto, Usuario usuarioInputDTO, Profesor profesorInputDto) {
        this.num_hours_week = studentInputDto.getNum_hours_week();
        this.profesor = profesorInputDto;
        this.usuario = usuarioInputDTO;
        this.coments = studentInputDto.getComents();
        this.branch = studentInputDto.getBranch();

// ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR ERROR
    }
}
