package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface Database extends MongoRepository<Data, String> {
    List<Data> findBySensor(@Param("sensor") String sensor);

}