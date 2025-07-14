import LedsSim.LedSim;
import java.awt.Color;
import src.codes.BlinkAnimation;
import src.codes.BlinkAnimationTimed;
import src.codes.LedController;

public class Main {
    public static void main(String[] args) {

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);
        BlinkAnimation blinkAnimation = new BlinkAnimation(new Color(100, 0, 40), 5);
        LC.setAnimation(new BlinkAnimationTimed(blinkAnimation, 10.0));

        while (true)
            LC.periodic();
    }
}
