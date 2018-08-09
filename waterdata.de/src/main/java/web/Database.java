package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface Database extends MongoRepository<Data, String> {
    @RestResource(path = "current")
    List<Data> findByTimestampNear(@Param("sensor") String sensor);
    List<Data> findBySensorAndTimestampBetween(@Param("period")String sensor,long timestamp1, long timestamp2);
}

