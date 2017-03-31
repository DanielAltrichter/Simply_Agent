import java.util.HashMap;

/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumWorld {
    enum world {LEFT,MIDDLE, RIGHT}
    public static boolean secondWorld = false;
    HashMap<world, Boolean> clean;
    world agentPosition;

    public VacuumWorld(HashMap<world,Boolean> clean, world agentPosition) {
        if(clean.size() < 3 && secondWorld == false){
            throw new IllegalArgumentException("Die Welt ist eine Scheibe und du bist runter gesprungen!");
        }
        this.clean = clean;
        this.agentPosition = agentPosition;
    }

}
