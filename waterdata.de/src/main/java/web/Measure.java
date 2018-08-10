package web;

import org.springframework.data.annotation.Id;

public class Measure {

    @Id private String id;
    private long start;
    private long stop;
    private boolean running = false;

    public void setStart(long start){
        setRunning(true);
        this.start = System.currentTimeMillis() / 1000L;
    }
    public long getStart(){
        return start;
    }
    public void setStop(long stop) {
        setRunning(false);
        this.stop = System.currentTimeMillis() / 1000L;
    }
    public long getStop() {
        return stop;
    }
    public void setRunning(boolean flag){
        this.running = true;
    }

    public boolean getRunning(){
        return running;
    }
}