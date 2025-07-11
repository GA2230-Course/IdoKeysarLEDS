package src.codes;
import LedsSim.LedStrip;

public class LedController {
    protected LedStrip strip;
    protected AnimationBase currentAnimation;

    public LedController(LedStrip strip){
        this.strip = strip;
    }

    public void periodic(){
        currentAnimation.periodic();     
    }

    public void setAnimation(AnimationBase animation){
        this.currentAnimation = animation;
        currentAnimation.setStrip(strip);
        currentAnimation.init();
    }
}
