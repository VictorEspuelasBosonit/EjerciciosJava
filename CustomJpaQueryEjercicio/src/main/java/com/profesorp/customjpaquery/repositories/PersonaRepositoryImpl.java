package com.profesorp.customjpaquery.repositories;

import static com.profesorp.customjpaquery.controller.PersonaController.EQUAL;
import static com.profesorp.customjpaquery.controller.PersonaController.GREATER_THAN;
import static com.profesorp.customjpaquery.controller.PersonaController.LESS_THAN;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.profesorp.customjpaquery.entities.PersonaEntity;

public class PersonaRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<PersonaEntity> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<PersonaEntity> query= cb.createQuery(PersonaEntity.class);
		Root<PersonaEntity> root = query.from(PersonaEntity.class);
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "id":
					predicates.add(cb.equal(root.get(field), (Integer)value));
					break;
				case "name":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "surname":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "created":
					String dateCondition=(String) conditions.get("dateCondition");					
					switch (dateCondition)
					{
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Date>get(field),(Date)value));
							break;
					}
					break;
			}
			
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 		
	}
}

