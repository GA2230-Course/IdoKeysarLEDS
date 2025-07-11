package src.codes;

import Utils.StopWatch;
import java.awt.Color;

public class BlinkAnimation extends AnimationBase {
    protected Color color;

    public BlinkAnimation(Color color, StopWatch stopWatch) {
        this.color = color;
        this.stopWatch = stopWatch;
    }

    public void init() {
        this.strip.setAll(color);
        strip.apply();     
        this.stopWatch.start();
    }

    public void periodic() {
        int timeInSeconds = (int)stopWatch.get();
        System.out.println(stopWatch.get());
        if (timeInSeconds%2 == 0){
            this.strip.setAll(new Color(0));
            strip.apply();     
        }
        else{
            this.strip.setAll(color);
            strip.apply();     
        }
    }

    public void setStrip(){
        this.strip = strip;
    }

    public double getRunTime(){
        return this.stopWatch.get();
    }
}
