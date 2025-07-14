package src.codes;

import Utils.StopWatch;
import java.awt.Color;

public class BlinkAnimation extends AnimationBase {
    protected Color color;
    protected int interval;
    private int startTime;
    protected StopWatch stopWatch = new StopWatch();

    public BlinkAnimation(Color color, int interval) {
        this.color = color;
        this.interval = interval;
    }

    @Override
    public void init() {
        this.stopWatch.start();
        this.strip.setAll(color);
        strip.apply();
        startTime = (int)stopWatch.get();
    }

    @Override
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

    public double getRunTime() {
        return this.stopWatch.get();
    }
}
