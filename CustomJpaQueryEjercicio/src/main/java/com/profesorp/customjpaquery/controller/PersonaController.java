package com.profesorp.customjpaquery.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import com.profesorp.customjpaquery.entities.PersonaEntity;
import com.profesorp.customjpaquery.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonaController {
	@Autowired
	PersonaRepository personaRepository;
	
	@Autowired
	EntityManager em;
	
	public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";
	
	@GetMapping("/get")
	public List<PersonaEntity> getData(@RequestParam(required=false,name="idPersona") Integer idPersona,
									   @RequestParam(value="namePersona",required=false) String nameCustomer,
									   @RequestParam(value="surnamePersona",required=false) String surnamePersona,
									   @RequestParam(required=false) @DateTimeFormat(pattern="dd-MM-yyyy") Date createdDate, @RequestParam(required=false) String dateCondition			)
	{		
		HashMap<String, Object> data=new HashMap<>();
		
		if (idPersona!=null)
			data.put("id",idPersona);
		if (nameCustomer!=null)
			data.put("name",nameCustomer);
		if (surnamePersona!=null)
			data.put("surnamePersona",surnamePersona);
		if (dateCondition==null)
			dateCondition=GREATER_THAN;
		if (!dateCondition.equals(GREATER_THAN) && !dateCondition.equals(LESS_THAN) && !dateCondition.equals(EQUAL))
			dateCondition=GREATER_THAN;	
		if (createdDate!=null)
		{
			data.put("created",createdDate);
			data.put("dateCondition",dateCondition);
		}
		
		return personaRepository.getData(data);

	}
}
