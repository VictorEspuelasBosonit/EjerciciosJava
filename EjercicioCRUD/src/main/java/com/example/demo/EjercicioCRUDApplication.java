package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class EjercicioCRUDApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioCRUDApplication.class, args);
    }

    @Bean
    @Primary
    public ServicePerson getServicePerson(){
        ServicePerson sp = new ServicePersonImp();
        return sp;
    }

}
