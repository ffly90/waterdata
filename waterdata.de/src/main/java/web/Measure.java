package web;

import org.springframework.data.annotation.Id;


public class Measure {

    @Id private String id;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;
    private long start;
    private long stop;

    @Override
    public String toString() {
        return "Measure{" +
                "id='" + id + '\'' +
                ", start=" + start +
                ", stop=" + stop +
                '}';
    }

    public void setStart(long ts_start){
        this.start = ts_start;
    }
    public long getStart(){
        return start;
    }
    public void setStop(long ts_stop) {
        this.stop = ts_stop;
    }
    public long getStop() {
        return stop;
    }

    public String getId() {
        return id;
    }
}
