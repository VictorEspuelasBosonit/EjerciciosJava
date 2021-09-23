package com.example.ciclovidabean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CicloVidaBeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CicloVidaBeanApplication.class, args);
	}





	//Hace operaciones antes de que el run de SpringApplication termine
//	@Override
//	public void run(String... args) throws Exception {
//
//	}

	@Bean
	public ClaseTerciaria claseTerciariaStartup() {
		return new ClaseTerciaria();
	}
}
