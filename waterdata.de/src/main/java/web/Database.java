package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "waterdata", path = "waterdata")
public interface Database extends MongoRepository<Data, String> {
    List<Data> findByLastName(@Param("name") String name);
}
