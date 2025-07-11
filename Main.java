import java.awt.Color;

import LedsSim.LedSim;
import Utils.StopWatch;
import src.codes.BlinkAnimation;
import src.codes.LedController;

public class Main {
    public static void main(String[] args) {
        // Initialize the LED simulation with a row layout
        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);
        LC.setAnimation(new BlinkAnimation(new Color(100, 0, 40), 5));
        while (true)
            LC.periodic();
    }
}
