package web;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "sensor", path = "sensor")
public interface Database extends MongoRepository<Data, String> {
    @RestResource(path = "sens")
    List<Data> findBySensor(@Param("sensor") String sensor);
    @RestResource(path = "timedec")
    List<Data> findBySensorOrderByTimestamp(@Param("sensor") String sensor);
    @RestResource(path = "period")
    List<Data> findBySensorAndTimestampBetween(@Param("period")String sensor,long timestamp1, long timestamp2);
}

