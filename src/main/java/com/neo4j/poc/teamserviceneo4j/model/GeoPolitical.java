package com.neo4j.poc.teamserviceneo4j.model;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@Data
@NodeEntity
public class GeoPolitical {

    @Id
    @GeneratedValue
    private long id;

    private String country;

    private String type;

    private String name;

    private String code;

    @Relationship(type = "CHILD_OF", direction = Relationship.OUTGOING)
    private GeoPolitical parent;

    private String alias;       // Set of aliases ???

}
