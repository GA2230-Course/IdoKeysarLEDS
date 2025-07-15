package src.codes;

import LedsSim.LedStrip;
import Utils.StopWatch;

public class AnimationTimed extends AnimationBase {

    protected double animationDuration;
    protected StopWatch stopWatch = new StopWatch();
    protected AnimationBase currentAnimation;

    public AnimationTimed(AnimationBase animation, double animationDuration) {
        this.currentAnimation = animation;
        this.animationDuration = animationDuration;
    }

    @Override
    public void setStrip(LedStrip strip){
        super.setStrip(strip);
        this.currentAnimation.setStrip(strip);
    }

    @Override
    public boolean isOver() {
        if (this.stopWatch.get() > animationDuration || this.currentAnimation.isOver()) { 
            return true;
        }
        return false;
    }

    @Override
    public void init(){
        this.currentAnimation.init();
        this.stopWatch.start();
    }
    @Override
    public void periodic(){
        this.currentAnimation.periodic();
    }
}
