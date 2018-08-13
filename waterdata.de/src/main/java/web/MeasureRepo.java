package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "measure", path = "measure")
public interface MeasureRepo extends MongoRepository<Measure, String>{
    List<Measure> findByRunningIsTrue();
}