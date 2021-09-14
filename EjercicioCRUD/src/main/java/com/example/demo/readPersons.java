package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("person")
public class readPersons {

    @Autowired
    ServicePerson sp;

    @GetMapping("getPerson/{id}")
    public Person getPerson(@PathVariable Integer id)
    {
        return sp.getPerson(id);
    }

    @GetMapping("getAllPerson")
    public List<Person> getAllPerson()
    {
        return sp.getAllPerson();
    }
}
