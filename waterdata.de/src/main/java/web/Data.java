package web;

import org.springframework.data.annotation.Id;


public class Data {

    @Id private String id;
    private String sensor;
    private double value;

    public long getTimestamp(){return System.currentTimeMillis() / 1000L;}

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