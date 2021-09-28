package com.example.jpa.infraestructure.domain.Persona;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@Table(name = "Usuario")
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_persona;

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    Student student;

    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
    Profesor profesor;

    @Column(nullable = false,length = 50)
    @Length(min = 6,max = 10, message = "The field must be at least 6 characters and at less 50")
    String user;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String surname;

    @Column(nullable = false)
    @Email(message = "No valido")
    String company_email;

    @Column(nullable = false)
    @Email(message = "No valido")
    String personal_email;

    @Column(nullable = false)
    String city;

    @Column(nullable = false)
    Boolean active;

    @Column(nullable = false)
    Date created_date;

    public Usuario(UsuarioInputDto usuarioInputDto) {
        this.user = usuarioInputDto.getUser();
        this.password = usuarioInputDto.getPassword();
        this.name = usuarioInputDto.getName();
        this.surname = usuarioInputDto.getSurname();
        this.company_email = usuarioInputDto.getCompany_email();
        this.personal_email = usuarioInputDto.getPersonal_email();
        this.city = usuarioInputDto.getCity();
        this.active = usuarioInputDto.getActive();
        this.created_date = usuarioInputDto.getCreated_date();
    }
}
