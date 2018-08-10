package web;

public class Meas_API_Is_Running
{
    private String _error;
    private String id;
    private boolean running;
    private String _okay;
    public String get_error ()
    {
        return _error;
    }
    public void set_error (String _error)
    {
        this._error = _error;
    }
    public String getId ()
    {
        return id;
    }
    public void setId (String id)
    {
        this.id = id;
    }
    public String get_okay ()
    {
        return _okay;
    }
    public void set_okay (String _okay)
    {
        this._okay = _okay;
    }

    @Override
    public String toString() {
        return "Meas_API_Is_Running{" +
                "_error='" + _error + '\'' +
                ", id='" + id + '\'' +
                ", running=" + running +
                ", _okay='" + _okay + '\'' +
                '}';
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}