package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerMeasure {

    @Autowired
    private Database2Custom datarepo;

    @GetMapping("measure/objectID")
    public List<Data> mes(@Param("id") String objectID) {
        return datarepo.test(objectID);
    }
}
