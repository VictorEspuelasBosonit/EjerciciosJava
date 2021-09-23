package com.example.crud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persona")
public class DeletePersonController {

    @Autowired
    InterfaceControler interfaceControler;


    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        return interfaceControler.deletePerson(id);
    }
}
