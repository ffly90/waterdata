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
    private boolean running = false;

    public void setStart(long start){
        setRunning(true);
        this.start = System.currentTimeMillis() / 1000L;
    }

    public void setStop(long ts_stop) {
        setRunning(false);
        stop=ts_stop;
    }

    public long getStart(){
        return start;
    }

    public long getStop() {
        return stop;
    }

    public void setRunning(boolean flag){
        this.running = flag;
    }

    public boolean getRunning(){
        return running;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Measure{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", start=" + start +
                ", stop=" + stop +
                ", running=" + running +
                '}';
    }
}

