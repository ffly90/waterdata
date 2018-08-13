package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class StartStopMeasure {


    @Autowired
    private MeasureRepo measureRepo;

    @RequestMapping("/measurement/start")
    public Meas_API_Start sta() {
        Measure obj_mongo = new Measure();
        obj_mongo.setStart(System.currentTimeMillis() / 1000L);
        obj_mongo.setState("running");
        measureRepo.save(obj_mongo);
        Meas_API_Start obj=new Meas_API_Start();
        obj.setId(obj_mongo.getId());
        return obj;
    }
    @RequestMapping("/measurement/{id}/stop")
    public Meas_API_Stop sto(@PathVariable(value="id") String id) {
        Optional<Measure> obj_mongo = measureRepo.findById(id);
        System.out.println(obj_mongo.toString());
        obj_mongo.get().setState("stopped");
        obj_mongo.get().setStop(System.currentTimeMillis() / 1000L);
        measureRepo.save(obj_mongo.get());
        Meas_API_Stop obj=new Meas_API_Stop();
        return obj;
    }
    @RequestMapping("/measurement/is_running")
    public Meas_API_Is_Running run() {
        Query query = new Query();
        query.addCriteria(Criteria.where("running").is(true));
        Meas_API_Is_Running obj=new Meas_API_Is_Running();
        List<Measure> obj_mongo = measureRepo.findByRunningIsTrue();
        if(obj_mongo != null) {
            System.out.println(obj_mongo.toString());
            obj.setId(obj_mongo.get(0).getId());
            obj.setRunning(obj_mongo.get(0).getRunning());
        } else {
            obj.setRunning(false);
        }
        return obj;
    }
}
