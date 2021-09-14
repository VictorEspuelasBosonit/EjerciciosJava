package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class ServicePersonImp implements ServicePerson {

    List<Person> listPerson = new ArrayList<>();
    Integer id =0;

    @Override
    public Person getPerson(Integer id) {
        for(Person p : listPerson)
        {
            if(p.getId()==id)
                return p;
        }
        return null;
    }

    @Override
    public List<Person> getAllPerson() {
        return listPerson;
    }

    @Override
    public Person addPerson(String name, Integer age, String poblation) {
        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(age);
        p.setPoblation(poblation);
        listPerson.add(p);
        id++;
        return p;
    }

    @Override
    public String deletePerson(Integer id) {
        if(listPerson.size()>id){
            if(listPerson.get(id).id == id){
                listPerson.remove(listPerson.get(id));
                return "Exito al borrar";

            }else{
                return "No borrado";
            }
        }else {
            return "User not found";
        }
    }

    @Override
    public String updatePerson(Person person) {
        return null;
                //no funciona nada :D;
    }
}
