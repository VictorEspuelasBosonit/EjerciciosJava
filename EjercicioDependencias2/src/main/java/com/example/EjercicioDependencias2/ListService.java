package com.example.EjercicioDependencias2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListService {
    List<Ciudad> ciudades = new ArrayList<>();

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public ListService(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public void añadirCiudades(Ciudad ciudad){
        ciudades.add(ciudad);
    }
}
