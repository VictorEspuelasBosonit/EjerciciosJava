package com.example.jpa.infraestructure.repository;

import com.example.jpa.infraestructure.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.name = ?1")
    List<Usuario> getByName(String name);
}