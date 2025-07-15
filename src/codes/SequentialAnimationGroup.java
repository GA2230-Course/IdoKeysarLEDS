package src.codes;

public class SequentialAnimationGroup extends AnimationBase {
    protected AnimationBase[] animations;
    private int currentAnimationIndex = 0;
    private int numOfAnimations;

    public SequentialAnimationGroup(AnimationBase... animations) {
        int i = 0;
        this.animations = new AnimationBase[animations.length];
        this.numOfAnimations = animations.length;
        for (AnimationBase animation : animations) {
            this.animations[i] = animation;
            i++;
        }
    }

    @Override
    public boolean isOver() {
        if (currentAnimationIndex == numOfAnimations - 1) {
            return animations[currentAnimationIndex].isOver();
        }
        return false;
    }

    @Override
    public void init() {
        animations[currentAnimationIndex].setStrip(strip);
        animations[currentAnimationIndex].init();
    }

    @Override
    public void periodic() {
        if (currentAnimationIndex < numOfAnimations) {
            if (animations[currentAnimationIndex].isOver()) {
                animations[currentAnimationIndex + 1].setStrip(strip);
                animations[currentAnimationIndex + 1].init();
                currentAnimationIndex++;
            }
            animations[currentAnimationIndex].periodic();
        }
    }
}
