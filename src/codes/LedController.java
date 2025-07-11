package src.codes;
import java.awt.Color;

import LedsSim.LedSim;
import LedsSim.LedStrip;

public class LedController {
    protected LedStrip strip;
    protected AnimationBase currentAnimation;


    public LedController(LedStrip strip){
        this.strip = strip;
    }

    

    public void periodic(){
        

        currentAnimation.setStrip(strip);
        currentAnimation.periodic();
        
    }

    public void setAnimation(AnimationBase animation){
        this.currentAnimation = animation;
    }
    
}
