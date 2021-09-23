package com.example.ciclovidabean;

import org.springframework.boot.CommandLineRunner;


public class ClaseTerciaria implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        if(args.length>0) {
            System.out.println("Soy la tercera clase y tengo de parametros " +args[0]);
            for(String s : args) {
                System.out.println(s);
            }
        }
        System.out.println("Soy la tercera clase y no tengo parametros");

    }
}
