package application.models;

import com.fasterxml.jackson.annotation.*;

public class Rain {
    private double the1H;

    @JsonProperty("1h")
    public double getThe1H() { return the1H; }
    @JsonProperty("1h")
    public void setThe1H(double value) { this.the1H = value; }
}