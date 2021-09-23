package com.example.crud.person;

import java.util.List;

public interface InterfaceControler {

    Person addPerson(Person p);
    Person putPerson(Integer id,Person p);
    String deletePerson(Integer id);
    Person getPersonId(Integer id);
    List<Person> getPersonName(String nombre);
    List<Person> getAllPerson();
    void iniciarLista();

}
