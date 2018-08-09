package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "value", path = "value")
public interface Database extends MongoRepository<Data, String> {
    List<Data> findBySensor(@Param("value") String value);
}
