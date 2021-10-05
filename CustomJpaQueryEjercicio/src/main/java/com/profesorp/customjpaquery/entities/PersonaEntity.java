package com.profesorp.customjpaquery.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity 
@Table(name="Persona")
@Data
public class PersonaEntity {
	@Id
	int id;
	
	@Column
	String name;
	
	@Column
	String surname;
		
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	Date created;
}
