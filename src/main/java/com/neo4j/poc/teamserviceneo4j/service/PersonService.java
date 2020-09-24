package com.neo4j.poc.teamserviceneo4j.service;

import com.neo4j.poc.teamserviceneo4j.dao.PersonRepository;
import com.neo4j.poc.teamserviceneo4j.model.Person;
import com.neo4j.poc.teamserviceneo4j.model.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Cacheable(cacheNames = "Person", key = "#name")
    public PersonDTO findByName(String name) {
        Person p = personRepository.findByName(name);
        return new PersonDTO(p);
    }

    public List<PersonDTO> findByTeammatesName(String name) {
        List<Person> personList = personRepository.findByTeammatesName(name);
        List<PersonDTO> dtoList = new ArrayList<>(personList.size());

        for (Person person : personList) {
            dtoList.add(new PersonDTO(person));
        }
        return dtoList;
    }

    public void addPerson(String name) {
        Person p = new Person(name);
        personRepository.save(p);
    }

    public void addTeammate(String name, String teammate) {
        Person p = personRepository.findByName(name);
        Person teammatePerson = personRepository.findByName(teammate);
        p.worksWith(teammatePerson);
        personRepository.save(p);
    }
}
