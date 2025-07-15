package src.codes;

import LedsSim.LedStrip;

public class LedController {
    protected LedStrip strip;
    protected AnimationBase currentAnimation;
    protected AnimationBase defaultAnimation;

    private boolean defaledInitted = false;

    public LedController(LedStrip strip) {
        this.strip = strip;
    }

    public void periodic() {
        if (currentAnimation.isOver() && defaultAnimation != null) {
            if (!defaledInitted) {
                defaultAnimation.init();
                defaledInitted = true;
            }
            defaultAnimation.periodic();
        } else if (!currentAnimation.isOver())
            currentAnimation.periodic();
        strip.apply();
    }

    public void setAnimation(AnimationBase animation) {
        this.currentAnimation = animation;
        currentAnimation.setStrip(strip);
        currentAnimation.init();
        strip.apply();
    }

    public void setDefaultAnimation(AnimationBase animation) {
        this.defaultAnimation = animation;
        defaultAnimation.setStrip(strip);
        defaultAnimation.init();
    }
}
