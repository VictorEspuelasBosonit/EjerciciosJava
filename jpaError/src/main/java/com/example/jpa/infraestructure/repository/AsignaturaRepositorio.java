package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Materia.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepositorio extends JpaRepository<Asignatura, String> {
}