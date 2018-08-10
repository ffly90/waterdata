package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerMeasure {

    @Autowired
    private Database2 datarepo;

    @GetMapping("measure/objectID")
    public MeasurementWithData mes(@Param("objectId") String objectID) {
        return datarepo.test(objectID);
    }
}
