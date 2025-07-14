package src.codes;

public class BlinkAnimationTimed extends BlinkAnimation {

    protected double animationDuration = 10.0;

    public BlinkAnimationTimed(BlinkAnimation blinkAnimation, double animationDuration) {
        super(blinkAnimation.color, blinkAnimation.interval);
        this.animationDuration = animationDuration;
    }

    @Override
    public boolean isOver() {
        if (this.stopWatch.get() > animationDuration) { 
            return true;
        }
        return false;
    }
}
