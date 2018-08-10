package web;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "measure", path = "measure/all")
public interface Database2_plain extends MongoRepository<Measure, String>{

}