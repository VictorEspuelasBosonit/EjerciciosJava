package com.example.crud.person;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

public class Person {

    private String nombre;
    private String poblacion;
    private String edad;
    private Integer id;
    private static int cont = 1;


    public Person(String nombre, String poblacion, String edad) {
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.edad = edad;
        this.id=cont++;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
