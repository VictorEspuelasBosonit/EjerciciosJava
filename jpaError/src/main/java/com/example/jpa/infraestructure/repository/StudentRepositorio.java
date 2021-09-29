package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepositorio extends JpaRepository<Student, String> {

}