package com.neo4j.poc.teamserviceneo4j.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PersonDTO {

    private String name;

    public Set<String> teammates;

    public PersonDTO(String name) {
        this.name = name;
    }

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.teammates = new HashSet<>(Optional.ofNullable(person.teammates)
                .orElse(Collections.emptySet())
                .stream()
                .map(Person::getName).collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return this.name + "'s teammates => " +
                Optional.ofNullable(this.teammates);
    }
}
