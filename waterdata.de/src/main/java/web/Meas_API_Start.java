package web;

public class Meas_API_Start
{
    private String _error;
    private String id;
    private String _okay= "true";
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
    public String toString()
    {
        return "ClassPojo [_error = "+_error+", id = "+id+", _okay = "+_okay+"]";
    }
}