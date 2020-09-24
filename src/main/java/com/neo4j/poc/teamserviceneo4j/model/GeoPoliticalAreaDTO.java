package com.neo4j.poc.teamserviceneo4j.model;

import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class GeoPoliticalAreaDTO {

    private long id;

    private String country;

    private String type;

    private String name;

    private String code;

    private String parent;

    private String alias;       // Set of aliases ???

    public GeoPoliticalAreaDTO(GeoPolitical area) {
        this.id = area.getId();
        this.country = area.getCountry();
        this.type = area.getType();
        this.name = area.getName();
        this.code = area.getCode();
        if (area.getParent() != null)
            this.parent = area.getParent().getName();
        this.alias = area.getAlias();
    }
}
