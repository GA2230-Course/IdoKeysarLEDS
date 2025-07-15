package src.codes;

import java.util.Random;

public class RandomAnimationGroup extends SequentialAnimationGroup {
    
    private Random rnd = new Random();

    public RandomAnimationGroup(AnimationBase... animations){
        super(animations);
    }

    @Override
    public boolean isOver(){
        return false;
    }

    @Override
    public void init(){
        int rndIndex = rnd.nextInt(numOfAnimations);
        currentAnimationIndex = rndIndex;
        animations[currentAnimationIndex].setStrip(strip);
        animations[currentAnimationIndex].init();
    }

    @Override
    public void periodic(){
        if (animations[currentAnimationIndex].isOver()) {
            int rndIndex = rnd.nextInt(numOfAnimations);
            animations[rndIndex].setStrip(strip);
            animations[rndIndex].init();
            currentAnimationIndex = rndIndex;
        }
        animations[currentAnimationIndex].periodic();
        
    }
}
