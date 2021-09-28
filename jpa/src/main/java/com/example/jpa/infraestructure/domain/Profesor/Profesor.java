package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Persona.Usuario;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Profesor")
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name ="system-uuid", strategy = "uuid")
    String id_profesor;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_persona")
    Usuario id_usuario;

    @Column(nullable = false)
    String coments;

    @Column(nullable = false)
    String branch;

    @OneToMany(mappedBy = "profesor")
    List<Student> students = new ArrayList<>();

    public Profesor(ProfesorInputDto profesorInputDto){
        this.branch = profesorInputDto.getBranch();
        this.coments = profesorInputDto.getComents();
    }
}
