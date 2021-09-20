package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Clase2 {
    @Bean
    CommandLineRunner ejecutame() { return p -> { System.out.println("Hola desde la clase secundaria"); };

    }
}
