package web;

import org.springframework.data.annotation.Id;


public class Data {

    @Id private String id;
    private String sensor;
    private double value;
    private long timestamp;

    public void setTimestamp(String dummy){
        timestamp = System.currentTimeMillis() / 1000L;
    }

    public long getTimestamp(){
        return timestamp;
    }

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