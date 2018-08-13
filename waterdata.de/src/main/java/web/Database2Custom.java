package web;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Database2Custom {
    List<Data> test(@Param("measureId") String measureId);
}