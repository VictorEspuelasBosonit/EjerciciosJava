package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, String> {

}