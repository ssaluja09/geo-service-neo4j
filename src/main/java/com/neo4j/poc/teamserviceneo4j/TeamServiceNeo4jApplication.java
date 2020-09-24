package com.neo4j.poc.teamserviceneo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableCaching
public class TeamServiceNeo4jApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamServiceNeo4jApplication.class, args);
	}

}
