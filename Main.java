import LedsSim.LedSim;
import java.awt.Color;

import src.codes.AnimationTimed;
import src.codes.BlinkAnimation;
import src.codes.LedController;

public class Main {
    public static void main(String[] args) {

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);
        BlinkAnimation blinkAnimation = new BlinkAnimation(new Color(100, 0, 40), 5);
        LC.setAnimation(new AnimationTimed(blinkAnimation, 10.0));
        BlinkAnimation defaultBlinkAnimation = new BlinkAnimation(new Color(0, 100, 40), 5);
        LC.setDefaultAnimation(defaultBlinkAnimation);

        while (true)
            LC.periodic();
    }
}
