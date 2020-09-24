package com.neo4j.poc.teamserviceneo4j.controller;

import com.neo4j.poc.teamserviceneo4j.model.GeoPoliticalAreaDTO;
import com.neo4j.poc.teamserviceneo4j.model.PersonDTO;
import com.neo4j.poc.teamserviceneo4j.service.AreaService;
import com.neo4j.poc.teamserviceneo4j.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping("/area/{name}")
    public GeoPoliticalAreaDTO getAreaByName(@PathVariable String name) {
        GeoPoliticalAreaDTO area = areaService.findByName(name);
        System.out.println(area);
        return area;
    }

}
