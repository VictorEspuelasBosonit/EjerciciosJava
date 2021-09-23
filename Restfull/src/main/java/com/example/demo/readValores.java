package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@Component
public class readValores {
    @Value("${valor1: no hay valor}")
    String valor1;
    @Value("${valor2: no hay valor}")
    String valor2;
    @PostConstruct
    @GetMapping("/leerValores")
    public void leerValores()
    {
        System.out.println(valor1);
        System.out.println(valor2);
    }
}
