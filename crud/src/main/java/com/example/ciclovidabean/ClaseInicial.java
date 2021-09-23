package com.example.ciclovidabean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class ClaseInicial {

    //leer https://programmerclick.com/article/18221588857/
    @PostConstruct
    public void escribirMensaje() {
        System.out.println("Hola desde clase inicial");
    }
}
