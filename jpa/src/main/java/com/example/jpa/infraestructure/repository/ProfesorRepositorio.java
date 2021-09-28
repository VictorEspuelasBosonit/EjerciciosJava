package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Profesor.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfesorRepositorio extends JpaRepository<Profesor, String> {
//    @Query("select u from Profesor u where u.name = ?1")
//    List<Profesor> getByName(String name);
}
