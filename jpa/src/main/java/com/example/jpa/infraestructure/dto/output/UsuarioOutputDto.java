package com.example.jpa.infraestructure.dto.output;

import com.example.jpa.infraestructure.domain.Persona.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class UsuarioOutputDto {

    int id_persona;
    String user;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_date;


    public UsuarioOutputDto(Usuario usuario) {
        this.id_persona = usuario.getId_persona();
        this.user = usuario.getUser();
        this.password = usuario.getPassword();
        this.name = usuario.getName();
        this.surname = usuario.getSurname();
        this.company_email = usuario.getCompany_email();
        this.personal_email = usuario.getPersonal_email();
        this.city = usuario.getCity();
        this.active = usuario.getActive();
        this.created_date = usuario.getCreated_date();
    }

}
