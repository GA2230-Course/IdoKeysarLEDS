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

    public void chooseAnimation(RobotEnum currentState){
        switch (currentState) {
            case INTAKE:
                currentAnimation = (new SolidAnimation(Color.RED));
                break;
            case CORAL_IN_ROBOT:
                currentAnimation = (new BlinkAnimation(Color.RED, 2));
                break;
            case L1:
                currentAnimation = (new BlinkAnimation(Color.GREEN, 2));
                break;
            case L2:
                currentAnimation = (new BlinkAnimation(Color.ORANGE, 2));
                break;
            case L3:
                currentAnimation = (new BlinkAnimation(Color.WHITE, 2));
                break;
            case L4:
                currentAnimation = (new BlinkAnimation(Color.BLUE, 2));
                break;
            case CLIMB:
                currentAnimation = (new CoolAnimation(Color.BLACK));     
                break; 
            default:
                currentAnimation = (new SolidAnimation(Color.BLACK));
                break;
        }
        setAnimation(currentAnimation);
    }
}
