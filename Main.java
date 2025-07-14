import LedsSim.LedSim;
import java.awt.Color;
import src.codes.BlinkAnimation;
import src.codes.LedController;

public class Main {
    public static void main(String[] args) {

        LedSim ledSim = LedSim.getRowsSim(100);
        LedController LC = new LedController(ledSim);

        LC.setAnimation(new BlinkAnimation(new Color(100, 0, 40), 5, 10.0));

        while (true)
            LC.periodic();
    }
}
