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
    public Person addPerson(@RequestBody Person person)
    {
        return sp.addPerson(person.getName(), person.getAge(), person.getPoblation());
    }
}
