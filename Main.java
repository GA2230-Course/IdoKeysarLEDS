import LedsSim.LedSim;
import java.awt.Color;

import src.codes.AnimationTimed;
import src.codes.BlinkAnimation;
import src.codes.CoolAnimation;
import src.codes.LedController;
import src.codes.SequentialAnimationGroup;
import src.codes.SolidAnimation;

public class Main {
    public static void main(String[] args) {

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);

        BlinkAnimation blinkAnimation = new BlinkAnimation(new Color(100, 0, 40), 5);
        CoolAnimation coolAnimation = new CoolAnimation(new Color(0, 100, 40), 5);

        AnimationTimed blink = new AnimationTimed(blinkAnimation, 10);
        AnimationTimed cool = new AnimationTimed(coolAnimation, 10);

        SequentialAnimationGroup sequentialAnimationGroup = new SequentialAnimationGroup(blink, cool, blink, cool);

        LC.setAnimation(sequentialAnimationGroup);

        while (true)
            LC.periodic();
    }
}
