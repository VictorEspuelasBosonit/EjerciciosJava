package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Estudiante.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepositorio extends JpaRepository<Student, String> {
 //   @Query("select u from Student u where u.name = ?1")
      List<Student> findByComents(String coments);
}
