package src.codes;

import LedsSim.*;
import Utils.StopWatch;

public abstract class AnimationBase {

    protected LedStrip strip;
    protected StopWatch stopWatch = new StopWatch();;

    public void setStrip(LedStrip strip) {
        this.strip = strip;
    }

    public void init(){
        this.stopWatch.start();
    }

    public abstract void periodic();

}
