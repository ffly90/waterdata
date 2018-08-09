package web;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;


public class Data {

    private static final Object Timestamp = new java.util.Date();
    @Id private String id;
    private String timestamp;
    private String sensor;
    private double value;

    public String getTimestamp(){return Timestamp;}

    public void setTimestamp(){this.timestamp = Timestamp;}

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}