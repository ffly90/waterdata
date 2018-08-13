package web;

import org.springframework.data.annotation.Id;


public class Data {
    @Id private String id;
    private String sensor;

    private double value;
    private long timestamp;
    public String measureID;


    public void setTimestamp(){
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

    public String getId() {
        return id;
    }

    public String getMeasureID() {
        return measureID;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", sensor='" + sensor + '\'' +
                ", value=" + value +
                ", timestamp=" + timestamp +
                ", measureID='" + measureID + '\'' +
                '}';
    }
}