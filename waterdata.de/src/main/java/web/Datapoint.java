package web;

public class Datapoint {
    private double pH;
    private double temp;

    public double getpH() {
        return pH;
    }
    public void setpH(double pH) {
        this.pH = pH;
    }
    public void setpH(String pH) {
        this.pH = Double.parseDouble(pH);
    }
    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }
}
