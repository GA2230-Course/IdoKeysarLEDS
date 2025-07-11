package src.codes;

import Utils.StopWatch;
import java.awt.Color;
import LedsSim.LedStrip;

public class BlinkAnimation extends AnimationBase {
    protected Color color;
    protected int interval;
    private int startTime;

    public BlinkAnimation(Color color, int interval) {
        this.color = color;
        this.interval = interval;
    }

    public void setStopWatch(StopWatch stopWatch){
        this.stopWatch = stopWatch;
    }

    public void init() {
        this.strip.setAll(color);
        strip.apply();
        setStopWatch(new StopWatch());
        this.stopWatch.start();
        startTime = (int)stopWatch.get();
    }

    public void periodic() {
        int timeInSeconds = (int) stopWatch.get();
        System.out.println(timeInSeconds);
        if (timeInSeconds % interval == 0) {
            startTime = timeInSeconds;
        }
        if (timeInSeconds - interval < startTime-1) {
            this.strip.setAll(Color.BLACK);
        } else {
            this.strip.setAll(color);
        }
    }

    public void setStrip(LedStrip strip) {
        this.strip = strip;
    }

    public double getRunTime() {
        return this.stopWatch.get();
    }
}
