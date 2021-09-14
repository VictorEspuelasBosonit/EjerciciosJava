package com.example.EjercicioDependencias2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class Controlador {

    @Autowired
    ListService ciudades;

    @PostMapping("/addCiudad")
    public Ciudad recibeCiudad(@RequestHeader("nombre") String nombreC, @RequestHeader("numeroHabitantes") int numeroHabitantesC)
    {
        Ciudad ciudad = new Ciudad(nombreC, numeroHabitantesC);
        ciudades.añadirCiudades(ciudad);
        return ciudad;
    }
}
