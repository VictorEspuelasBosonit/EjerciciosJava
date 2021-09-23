package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface ServicePerson {

    List<Person> listPerson = new ArrayList<>();

    Person getPerson(Integer id);
    List<Person> getAllPerson();
    Person addPerson(String name, Integer age, String poblation);
    String deletePerson(Integer id);
    String updatePerson(PersonaInputDTO person);
}
