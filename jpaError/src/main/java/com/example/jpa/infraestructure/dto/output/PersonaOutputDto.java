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
    Date create_date;
    String imagen_url;
    Date termination_date;


    public PersonaOutputDto(Persona p) {
        if (p == null) {
            return;
        }
        setId_persona(p.getId_persona());
        setName(p.getName());
        setUser(p.getUser());
        setPassword(p.getPassword());
        setSurname(p.getSurname());
        setCompany_email(p.getCompany_email());
        setPersonal_email(p.getPersonal_email());
        setCity(p.getCity());
        setActive(p.getActive());
        setCreate_date(p.getCreate_date());
        setImagen_url(p.getImagen_url());
        setTermination_date(p.getTermination_date());

    }

}
