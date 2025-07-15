package src.codes;
import java.awt.Color;
import Utils.StopWatch;
import java.util.Random;

public class CoolAnimation extends AnimationBase{
    protected Color color;
    protected int interval;
    protected int startTime;
    protected StopWatch stopWatch = new StopWatch();

    Color[] leds;


    public CoolAnimation(Color color, int interval) {
        this.color = color;
        this.interval = interval;
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public void init() {
        this.stopWatch.start();
        this.strip.setAll(color);
        strip.apply();
        startTime = (int)stopWatch.get();
        leds = new Color[strip.getLedCount()];

    }

    @Override
    public void periodic() {
        int timeInSeconds = (int) stopWatch.get();
        System.out.println(timeInSeconds);
        if (timeInSeconds % 2 == 0){
            Random random = new Random();
            int red = random.nextInt(20);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);

            int i = random.nextInt(strip.getLedCount());
            int length = random.nextInt(30);
            this.strip.setLed(new Color(red, green, blue), i);
            for (int j = 0; j < length; j++) {
                int nextIndex = (i + j) % strip.getLedCount();
                this.strip.setLed(new Color(red, green, blue), nextIndex);
            }
        }
    }

    public double getRunTime() {
        return this.stopWatch.get();
    }

    
}
