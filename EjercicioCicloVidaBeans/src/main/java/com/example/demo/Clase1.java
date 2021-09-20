package com.example.demo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Clase1 {

    @PostConstruct
    public void ejecutate()
    {
        System.out.println("Hola desde clase inicia");
    }
}
