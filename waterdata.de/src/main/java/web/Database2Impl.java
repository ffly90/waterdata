package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Database2Impl implements Database2Custom {

    @Autowired
    private MeasureRepo repo;

    @Autowired
    private Database dataRepo;

    @Override
    public List<Data> test(String measureId) {

        Optional<Measure> m = repo.findById(measureId);

        List<Data> dataList = new ArrayList<>();

        dataRepo.findAll().forEach(data -> {
            if (data.getMeasureID().equals(measureId)) {
                System.out.println("Added " + data.getId());
                dataList.add(data);
            }
        });

        return dataList;
    }
}
