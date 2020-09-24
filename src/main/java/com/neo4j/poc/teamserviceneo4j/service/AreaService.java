package com.neo4j.poc.teamserviceneo4j.service;

import com.neo4j.poc.teamserviceneo4j.dao.AreaRepository;
import com.neo4j.poc.teamserviceneo4j.model.GeoPolitical;
import com.neo4j.poc.teamserviceneo4j.model.GeoPoliticalAreaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    @Cacheable(cacheNames = "Area", key = "#name")
    public GeoPoliticalAreaDTO findByName(String name) {
        GeoPolitical area = areaRepository.findByName(name);
        return new GeoPoliticalAreaDTO(area);
    }

}
