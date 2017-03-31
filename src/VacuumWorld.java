import java.util.HashMap;

/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumWorld {
    enum world {LEFT,MIDDLE, RIGHT}
    HashMap<world, Boolean> clean;
    public VacuumWorld(HashMap<world,Boolean> clean) {
        if(clean.size() < 3){
            throw new IllegalArgumentException("Die Welt ist eine Scheibe und du bist runter gesprungen!");
        }
        this.clean = clean;
    }

}
