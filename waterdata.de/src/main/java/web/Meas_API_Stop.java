package web;

public class Meas_API_Stop
{
    private String _error;
    private String _okay;
    public String get_error ()
    {
        return _error;
    }
    public void set_error (String _error)
    {
        this._error = _error;
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
        return "ClassPojo [_error = "+_error+", _okay = "+_okay+"]";
    }
}