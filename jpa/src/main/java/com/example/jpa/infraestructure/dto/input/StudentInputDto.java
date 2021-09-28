package com.example.jpa.infraestructure.dto.input;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentInputDto {
    String id_profesor;
    int id_usuario;
    int num_hours_week;
    String coments;
    String branch;
}
