package com.neo4j.poc.teamserviceneo4j.controller;

import com.neo4j.poc.teamserviceneo4j.model.PersonDTO;
import com.neo4j.poc.teamserviceneo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/person/{name}")
    public PersonDTO getPersonByName(@PathVariable String name) {
        PersonDTO p = personService.findByName(name);
        System.out.println(p);
        return p;
    }

    @GetMapping("/person")
    public List<PersonDTO> getPersonByTeammate(@RequestParam String teammate) {
        return personService.findByTeammatesName(teammate);
    }

    @PostMapping("/person")
    public void addTeammate(@RequestParam String name) {
        personService.addPerson(name);
    }

    @PutMapping("/person/{name}")
    public void addTeammate(@PathVariable String name, @RequestParam String teammate) {
        personService.addTeammate(name, teammate);
    }
}
