package com.example.crud.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("persona")
public class PutPersonController {

    @Autowired
    InterfaceControler interfaceControler;


    @PutMapping("{id}")
    public Person putPerson(@PathVariable("id") Integer id, @RequestBody(required = false) Person p) {
        return interfaceControler.putPerson(id,p);
    }

}
