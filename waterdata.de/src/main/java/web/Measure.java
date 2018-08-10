package web;

import org.springframework.data.annotation.Id;


public class Measure {

    @Id private String id;
    private long start;
    private long stop;

    public void setStart(long ts_start){
        this.start = flag;
    }
    public long getStart(){
        return start;
    }
    public void setStop(long ts_stop) {
        this.stop = flag;
    }
    public long getStop() {
        return stop;
    }
}
