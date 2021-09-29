package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {

    @Query("select u from Usuario u where u.name = ?1")
    List<Persona> getByName(String name);
}