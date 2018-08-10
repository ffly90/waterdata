package web;

import org.springframework.data.repository.query.Param;

public interface Database2Custom {
    MeasurementWithData test (@Param("measureId") String measureId);
    MeasurementWithData test2 (@Param("objectID") String objectID);
}