import java.awt.Color;

import LedsSim.LedSim;
import src.codes.LedController;
import src.codes.SolidAnimation;

public class Main {
    public static void main(String[] args) {
        // Initialize the LED simulation with a row layout

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);
        LC.setAnimation(new SolidAnimation(new Color(100, 0, 40)));
        while(true)
            LC.periodic();
    }
}
