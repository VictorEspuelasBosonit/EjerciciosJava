package com.example.crud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persona")
public class GetPersonController {

    @Autowired
    InterfaceControler interfaceControler;


    @GetMapping("{id}")
    public Person getPersonId(@PathVariable("id") Integer id) {
        return interfaceControler.getPersonId(id);
    }

    @GetMapping("nombre/{nombre}")
    public List<Person> getPersonName(@PathVariable("nombre") String nombre) {
        return interfaceControler.getPersonName(nombre);
    }

    @GetMapping("userList")
    public List<Person> getllPerson() {
        return interfaceControler.getAllPerson();
    }

}
