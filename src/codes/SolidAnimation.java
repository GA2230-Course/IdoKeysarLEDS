package src.codes;

import java.awt.Color;
import Utils.StopWatch;

public class SolidAnimation extends AnimationBase {

    protected Color color;

    public SolidAnimation(Color color, StopWatch stopWatch) {
        this.color = color;
        this.stopWatch = stopWatch;
    }

    public void init() {
        this.strip.setAll(color);
    }

    public void periodic() {
        this.stopWatch.start();
    }

    public void setStrip(){
        this.strip = strip;
    }

    public double getRunTime(){
        return this.stopWatch.get();
    }
}
