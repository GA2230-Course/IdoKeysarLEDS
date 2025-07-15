package src.codes;

public abstract class AnimationGroup extends AnimationBase {
    protected AnimationBase[] animations;
    protected int currentAnimationIndex = 0;
    protected int nextIndex = 0;
    protected int numOfAnimations;

    public AnimationGroup(AnimationBase... animations) {
        int i = 0;
        this.animations = new AnimationBase[animations.length];
        this.numOfAnimations = animations.length;
        for (AnimationBase animation : animations) {
            this.animations[i] = animation;
            i++;
        }
    }

    @Override
    public  boolean isOver() {
        return false;
    }

    @Override
    public void init() {
        superInit();
    }

    protected void superInit(){
        animations[currentAnimationIndex].setStrip(strip);
        animations[currentAnimationIndex].init();
    }

    @Override
    public void periodic() {
        animations[currentAnimationIndex].periodic();
        if (animations[currentAnimationIndex].isOver()) {
            animations[nextIndex].setStrip(strip);
            animations[nextIndex].init();
            currentAnimationIndex = nextIndex;
        }
    }

    abstract int chooseNextIndex();
}
