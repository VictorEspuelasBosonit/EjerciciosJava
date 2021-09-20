package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Leer1 {
    @Value("${VAR1: no hay valor}")
    String VAR1;
    @Value("${My.VAR2: no hay valor}")
    String MyVAR2;
    @GetMapping("/leerAtributo")
    public void leerAtributo()
    {
        System.out.println(VAR1);
        System.out.println(MyVAR2);

    }
}
