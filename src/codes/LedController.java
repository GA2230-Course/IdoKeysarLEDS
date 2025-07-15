package src.codes;

import java.awt.Color;

import LedsSim.LedStrip;

public class LedController {
    protected LedStrip strip;
    protected AnimationBase currentAnimation;
    protected AnimationBase defaultAnimation;

    private boolean defauledInitted = false;

    public LedController(LedStrip strip) {
        this.strip = strip;
    }

    public void periodic() {
        if (currentAnimation.isOver() && defaultAnimation != null) {
            if (!defauledInitted) {
                defaultAnimation.init();
                defauledInitted = true;
            }
            defaultAnimation.periodic();
        } else if (!currentAnimation.isOver())
            currentAnimation.periodic();
        strip.apply();
    }

    public void setAnimation(AnimationBase animation) {
        this.currentAnimation = animation;
        defauledInitted = false;
        currentAnimation.setStrip(strip);
        currentAnimation.init();
        strip.apply();
    }

    public void setDefaultAnimation(AnimationBase animation) {
        this.defaultAnimation = animation;
        defaultAnimation.setStrip(strip);
        defaultAnimation.init();
    }

    public AnimationBase chooseAnimation(RobotEnum currentState){
        switch (currentState) {
            case INTAKE:
                return (new SolidAnimation(Color.RED));
            case CORAL_IN_ROBOT:
                return (new BlinkAnimation(Color.RED, 2));
            case L1:
                return (new BlinkAnimation(Color.GREEN, 2));
            case L2:
                return (new BlinkAnimation(Color.ORANGE, 2));
            case L3:
                return (new BlinkAnimation(Color.WHITE, 2));
            case L4:
                return (new BlinkAnimation(Color.BLUE, 2));
            case CLIMB:
                return (new CoolAnimation(Color.BLACK));      
            default:
                return (new SolidAnimation(Color.BLACK));
        }
    }
}
