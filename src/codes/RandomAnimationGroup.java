package src.codes;

import java.util.Random;

public class RandomAnimationGroup extends SequentialAnimationGroup {

    private Random rnd = new Random();

    public RandomAnimationGroup(AnimationBase... animations) {
        super(animations);
    }

    @Override
    public void init() {
        currentAnimationIndex = rnd.nextInt(numOfAnimations);
        initCurrentAnimation();
    }

    @Override
    public int chooseNextIndex() {
        nextIndex = rnd.nextInt(numOfAnimations);
        return rnd.nextInt(numOfAnimations);
    }
}
