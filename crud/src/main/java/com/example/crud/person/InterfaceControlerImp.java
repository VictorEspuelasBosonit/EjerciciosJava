package com.example.crud.person;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterfaceControlerImp implements InterfaceControler{

    List<Person> listaPersona= new ArrayList<>();

    @Override
    public Person addPerson(Person p) {
        listaPersona.add(p);
        return p;
    }

    @Override
    public Person putPerson(Integer id,Person p) {
        //problema de que se construye un nuevo person y me añade uno al contador
        return listaPersona.set(id,p);
    }

    @Override
    public String deletePerson(Integer id) {
        if(listaPersona.remove(getPersonId(id))) {
            return "Borrado";
        } else {
            return "No se pudo borrar";
        }
    }

    @Override
    public Person getPersonId(Integer id) {

        System.out.println(id);
        var auxp = listaPersona.stream().filter(aux -> aux.getId() == id).collect(Collectors.toList());
        System.out.println(auxp.size());
        if(auxp.size()==0) {
            return null;
        }
        return auxp.get(0);
    }

    @Override
    public List<Person> getPersonName(String nombre) {
        return listaPersona.stream().filter(aux -> aux.getNombre().equals(nombre)).collect(Collectors.toList());
    }

    @Override
    public List<Person> getAllPerson() {
        return listaPersona;
    }

    @Override
    public void iniciarLista() {
        Person aux = new Person("Paco","Madrid","30");
        Person aux2 = new Person("Carlos","Barcelona","20");
        Person aux3 = new Person("Ana","Logroño","26");
        listaPersona.add(aux);
        listaPersona.add(aux2);
        listaPersona.add(aux3);
    }
}
