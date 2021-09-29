package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Persona.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
    public List<Persona> findByName(String name);

}