package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class Database2Impl implements Database2Custom {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public Database2Impl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public MeasurementWithData test(String measureId) {
        MeasurementWithData mes = mongoTemplate.findOne(new Query(Criteria.where("id").is(measureId)), MeasurementWithData.class, "measure");
        mes.setDataList(mongoTemplate.find(new Query(Criteria.where("measureId").is(measureId)), Data.class, "data"));
        return mes;
    }
}
