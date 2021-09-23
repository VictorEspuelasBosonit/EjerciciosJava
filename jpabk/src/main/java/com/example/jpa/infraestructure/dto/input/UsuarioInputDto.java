package com.example.jpa.infraestructure.dto.input;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data //Setters y getters
@NoArgsConstructor
public class UsuarioInputDto {

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

}
