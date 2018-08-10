package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.client.RestTemplate;

@RestController
public class StartStopMeasure {
    MongoOperations mongoOperation;

    public StartStopMeasure() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");
    }
    @RequestMapping("/measurement/start")
    public Meas_API_Start sta() {
        Measure obj_mongo = new Measure();
        obj_mongo.setStart(System.currentTimeMillis() / 1000L);
        mongoOperation.save(obj_mongo,"measure");
        Meas_API_Start obj=new Meas_API_Start();
        obj.setId(obj_mongo.getId());
        return obj;
    }
}
