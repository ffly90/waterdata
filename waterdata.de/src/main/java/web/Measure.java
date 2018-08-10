package web;

import org.springframework.data.annotation.Id;

public class Measure {

    @Id private String id;
    private long start;
    private long stop;
<<<<<<< HEAD
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
=======

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
>>>>>>> 0bdd2e02ce3f14632f5eb6b875685ddc095a81b6
    }
    public long getStop() {
        return stop;
    }
<<<<<<< HEAD
    public void setRunning(boolean flag){
        this.running = true;
    }

    public boolean getRunning(){
        return running;
    }
}
=======

    public String getId() {
        return id;
    }
}
>>>>>>> 0bdd2e02ce3f14632f5eb6b875685ddc095a81b6
