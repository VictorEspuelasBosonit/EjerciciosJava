package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("person")
public class addPersons {

    @Autowired
    ServicePerson sp;

    @PostMapping
    public PersonaOutputDTO addPerson(@RequestBody PersonaInputDTO p) throws Exception
    {
        Person person = new Person();
        person.setName(p.getName());
        person.setAge(p.getAge());
        person.setPoblation(p.getPoblation());
        sp.addPerson(person.getName(), person.getAge(), person.getPoblation());

        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO();
        personaOutputDTO.setName(person.getName());
        return personaOutputDTO;
    }
}
