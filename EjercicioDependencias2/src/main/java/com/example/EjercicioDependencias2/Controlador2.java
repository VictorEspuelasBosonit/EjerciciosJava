package com.example.EjercicioDependencias2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@SpringBootApplication
public class Controlador2 {

    @Autowired
    ListService ciudades;

    @PostMapping("/getCiudad")
    public ListService getArrayListCiudad()
    {
        return ciudades;
    }
}
