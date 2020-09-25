# geo-service-neo4j
PoC on Apache Ignite + Neo4J

Steps to run geo-service-neo4j:

1. Download and Install Apache-ignite 2.8.1 from : https://ignite.apache.org/download.cgi
2. Go to the bin folder of Ignite installation directory `{ignite}/bin` from the command shell and start an Ignite-node: `./ignite.sh` 
3. Download and Install Neo4J from : https://neo4j.com/download/
4. Open Neo4J and create a new DB. Click on **Options -> Manage**. Then Select **Open Folder**. Now open **import** folder.
5. Copy **GeoPoliticalArea.csv** and **Zones.csv** from **csv** folder and paste it to the import folder opened in the previous step.
6. Now run the below scripts:

```
LOAD CSV WITH HEADERS FROM "file:///GeoPoliticalArea.csv" AS row
MERGE (e:GeoPolitical {politicalAreaId:row.politicalAreaId})
ON CREATE SET e.country = row.country, e.code = row.code, e.type = row.type, e.name=row.name

LOAD CSV WITH HEADERS FROM "file:///GeoPoliticalArea.csv" AS row
MATCH (employee:GeoPolitical {politicalAreaId: row.politicalAreaId})
MATCH (manager:GeoPolitical {politicalAreaId: row.parentId})
MERGE (employee)-[:CHILD_OF]->(manager);
 
 
LOAD CSV WITH HEADERS FROM "file:///Zone.csv" AS row
MERGE (e:Zone {zoneId:row.zoneId})
ON CREATE SET e.country = row.country,  e.type = row.type, e.name=row.name
 
LOAD CSV WITH HEADERS FROM "file:///Zone.csv" AS row
MATCH (z:Zone {zoneId:row.zoneId})
with  z ,split(row.linkedPoliticalArea,",") as s
unwind s as range
//return z,toInteger(range)
MATCH (g:GeoPolitical {politicalAreaId: range})
MERGE (z)-[:LINKED_TO]->(g)
RETURN z,g
 
// Query: All District associated with Ind
 
 
MATCH (N:GeoPolitical{code:'IND'})<-[:CHILD_OF*]-(M:GeoPolitical{type:'DISTRICT'}) RETURN M.name
 
// ALL PARENT NODES
 
MATCH (N:GeoPolitical{name:'Bangalore'})-[:CHILD_OF*]->(M:GeoPolitical)
RETURN M.name ORDER BY M DESC
 
// ALL Child Nodes
 
MATCH (N:GeoPolitical{name:'India'})<-[:CHILD_OF]-(M:GeoPolitical)
RETURN M.name ORDER BY M DESC
```



Import and run `geo-service-neo4j` in IntelliJ.

You try the below end-point using Curl/Postman:

1. http://localhost:9091/area/Delhi