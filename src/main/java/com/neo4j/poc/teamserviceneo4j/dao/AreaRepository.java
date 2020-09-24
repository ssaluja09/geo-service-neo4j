package com.neo4j.poc.teamserviceneo4j.dao;

import com.neo4j.poc.teamserviceneo4j.model.GeoPolitical;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AreaRepository extends Neo4jRepository<GeoPolitical, Long> {

    GeoPolitical findByName(String name);

}
