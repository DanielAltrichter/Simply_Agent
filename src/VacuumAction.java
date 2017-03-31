/**
 * Created by s-daltri on 28.03.17.
 */
public class VacuumAction {
    public enum Aecktion  {LEFT, RIGHT, CLEAN, STOP}
    public String action(Aecktion aecktion) {
        switch (aecktion) {
            case LEFT: return "LEFT";
            case RIGHT: return "RIGHT";
            case CLEAN: return "CLEAN";
            case STOP: return "STOP";
            default: return "FAIL";
        }
    }
}
