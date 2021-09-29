package com.example.jpa.infraestructure.dto.output;

import com.example.jpa.infraestructure.domain.Persona.Persona;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class PersonaOutputDto {

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


    public PersonaOutputDto(Persona persona) {
        this.id_persona = persona.getId_persona();
        this.user = persona.getUser();
        this.password = persona.getPassword();
        this.name = persona.getName();
        this.surname = persona.getSurname();
        this.company_email = persona.getCompany_email();
        this.personal_email = persona.getPersonal_email();
        this.city = persona.getCity();
        this.active = persona.getActive();
        this.created_date = persona.getCreated_date();
    }

}
