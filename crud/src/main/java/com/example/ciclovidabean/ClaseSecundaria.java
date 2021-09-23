package com.example.ciclovidabean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
public class ClaseSecundaria implements CommandLineRunner {

//  se ejecutará inmediatamente después de que se inicie el servicio
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hola desde clase secundaria");
    }
}
