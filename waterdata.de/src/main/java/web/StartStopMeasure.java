package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
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
        obj_mongo.setState("running");
        mongoOperation.save(obj_mongo,"measure");
        Meas_API_Start obj=new Meas_API_Start();
        obj.setId(obj_mongo.getId());
        return obj;
    }
    @RequestMapping("/measurement/{id}/stop")
    public Meas_API_Stop sto(@PathVariable(value="id") String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Measure obj_mongo = mongoOperation.findOne(query,Measure.class,"measure");
        System.out.println(obj_mongo.toString());
        obj_mongo.setState("stopped");
        obj_mongo.setStop(System.currentTimeMillis() / 1000L);
        mongoOperation.save(obj_mongo,"measure");
        Meas_API_Stop obj=new Meas_API_Stop();
        return obj;
    }
 /*   @RequestMapping("/measurement/is_running")
    public Meas_API_Start sta() {
        Measure obj_mongo = new Measure();
        obj_mongo.setStart(System.currentTimeMillis() / 1000L);
        obj_mongo.setState("running");
        mongoOperation.save(obj_mongo,"measure");
        Meas_API_Start obj=new Meas_API_Start();
        obj.setId(obj_mongo.getId());
        return obj;
    }*/
}
