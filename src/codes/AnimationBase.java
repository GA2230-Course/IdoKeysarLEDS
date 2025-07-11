package src.codes;

import LedsSim.*;
import Utils.StopWatch;
public abstract class AnimationBase {
    protected LedStrip strip;
    protected StopWatch stopWatch;

    public void setStrip(LedStrip strip) {
        this.strip = strip;
    }

    public abstract void init();

    public abstract void periodic();

    public abstract double getRunTime();
}
