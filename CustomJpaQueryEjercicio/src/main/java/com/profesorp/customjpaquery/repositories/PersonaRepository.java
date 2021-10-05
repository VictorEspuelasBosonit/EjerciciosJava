package com.profesorp.customjpaquery.repositories;

import java.util.HashMap;
import java.util.List;

import com.profesorp.customjpaquery.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
	
	public List<PersonaEntity> getData(HashMap<String, Object> conditions);
}
