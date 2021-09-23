package com.example.jpa.infraestructure;

import com.example.jpa.infraestructure.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {



	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
