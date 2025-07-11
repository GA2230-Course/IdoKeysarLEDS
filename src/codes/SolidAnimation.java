package src.codes;
import LedsSim.*;
import Utils.*;
import java.awt.Color;

public class SolidAnimation extends AnimationBase {
    protected Color color;

    public SolidAnimation(Color color){
        this.color = color;      
    }

    public void init(){
        
        
        this.strip.setAll(color);
    }
    public void periodic(){
        
        this.strip.setAll(color);
        this.strip.apply();
        
        
    }

    
}
