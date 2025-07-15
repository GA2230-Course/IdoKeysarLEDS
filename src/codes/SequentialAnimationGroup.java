package src.codes;

public class SequentialAnimationGroup extends AnimationGroup {

    public SequentialAnimationGroup(AnimationBase... animations) {
        super(animations);
    }

    @Override
    public boolean isOver() {
        return currentAnimationIndex == numOfAnimations;
    }

    @Override
    public void init() {
        initCurrentAnimation();
    }

    @Override
    public int chooseNextIndex() {
        if (currentAnimationIndex < numOfAnimations) {
            currentAnimationIndex++;
        }
        return currentAnimationIndex;
    }

}
