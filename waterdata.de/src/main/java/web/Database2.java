package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "measure", path = "measure")
public interface Database2 extends MongoRepository<Measure, String>, Database2Custom{

}