package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("person")
public class updatePersons {

    @Autowired
    ServicePerson sp;

    @DeleteMapping("{id}")
    public String updatePerson(@RequestBody PersonaInputDTO person)
    {
        return sp.updatePerson(person);
    }

}
