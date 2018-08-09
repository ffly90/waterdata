package web;

import org.springframework.data.annotation.Id;


public class Measure {

    @Id private String id;
    private boolean start;
    private boolean stop;

    public void setStart(boolean flag){
        this.start = flag;
    }
    public boolean getStart(){
        return start;
    }
    public void setStop(boolean flag) {
        this.stop = flag;
    }
    public boolean getStop() {
        return stop;
    }
}