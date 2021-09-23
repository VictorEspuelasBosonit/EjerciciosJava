package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Provider;

@RestController
@RequestMapping("person")
public class deletePersons {

        @Autowired
        ServicePerson sp;

        @DeleteMapping("{id}")
        public String deletePerson(@PathVariable Integer id)
        {
                return sp.deletePerson(id);
        }
}
